package org.singledog.dogmall.datasource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.AbstractDataSource;
import org.springframework.util.Assert;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.*;

/**
 * Routing datasource
 *
 * @author ZheMing Liu
 * @since 1.0.0-RELEASE
 */
@Slf4j
public class DynamicRoutingDataSource extends AbstractDataSource {

    /**
     * Whether fair
     */
    private boolean fair;

    /**
     * Master datasource queue
     */
    private Queue<DataSourceHolder> master = new ArrayBlockingQueue<>(2);

    /**
     * Slave datasource queue
     */
    private Queue<DataSourceHolder> slave = new ArrayBlockingQueue<>(2);

    /**
     * Master and slave datasource queue map
     */
    private static final Map<String, Queue<DataSourceHolder>> MS_MAP = new ConcurrentHashMap<>(2);

    /**
     * Id and datasource map
     */
    private static final Map<String, DataSourceHolder> ID_MAP = new ConcurrentHashMap<>(2);

    /**
     * Create a new {@link DynamicRoutingDataSource}
     *
     * @param master master list
     * @param slave  slave list
     */
    public DynamicRoutingDataSource(BlockingQueue<DataSourceHolder> master, BlockingQueue<DataSourceHolder> slave) {
        this(master, slave, false);
    }

    /**
     * Create a new {@link DynamicRoutingDataSource}
     *
     * @param master master list
     * @param slave  slave list
     * @param fair   whether fair
     */
    public DynamicRoutingDataSource(BlockingQueue<DataSourceHolder> master, BlockingQueue<DataSourceHolder> slave, boolean fair) {
        this.fair = fair;
        if (master != null) {
            this.master = master;
        }
        if (slave != null) {
            this.slave = slave;
        }
        MS_MAP.put("master", this.master);
        MS_MAP.put("slave", this.slave);
        for (DataSourceHolder ms : master) {
            ID_MAP.put(ms.getId(), ms);
        }
        for (DataSourceHolder sl : slave) {
            ID_MAP.put(sl.getId(), sl);
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        DataSourceHolder dataSourceHolder = getDatasource();
        if (dataSourceHolder == null) {
            return null;
        }
        log.info("The thread {} datasource is {}", Thread.currentThread().getName(), dataSourceHolder.getId());
        return dataSourceHolder.getDataSource().getConnection();
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        Assert.hasText(username, "The username is blank");
        Assert.hasText(password, "The password is blank");
        DataSourceHolder dataSourceHolder = getDatasource();
        if (dataSourceHolder == null) {
            return null;
        }
        log.info("The thread {} datasource is {}", Thread.currentThread().getName(), dataSourceHolder.getId());
        return dataSourceHolder.getDataSource().getConnection(username, password);
    }

    /**
     * Get the datasource
     *
     * @return {@link DataSourceHolder}
     */
    private DataSourceHolder getDatasource() {
        DataSourceHolder dataSourceHolder = null;
        DataSourceLocationHolder holder = DataSourceLocationContext.getDataSourceLocation();
        DataSourceLocationMode mode = holder.getMode();
        Queue<DataSourceHolder> queue = null;
        if (mode == DataSourceLocationMode.ID) {
            return ID_MAP.get(holder.getKey());
        } else {
            queue = MS_MAP.get(holder.getKey());
        }
        if (queue == null || queue.size() == 0) {
            return dataSourceHolder;
        } else if (queue.size() == 1) {
            return queue.peek();
        }
        if (fair) {
            synchronized (MS_MAP) {
                dataSourceHolder = queue.poll();
                queue.add(dataSourceHolder);
            }
        } else {
            dataSourceHolder = queue.poll();
            queue.add(dataSourceHolder);
        }
        return dataSourceHolder;
    }
}
