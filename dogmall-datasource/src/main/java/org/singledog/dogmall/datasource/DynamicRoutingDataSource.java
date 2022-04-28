package org.singledog.dogmall.datasource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.AbstractDataSource;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.*;

/**
 * Routing datasource
 *
 * @author Zheming Liu
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
    private Queue<DataSource> master = new ArrayBlockingQueue<>(2);

    /**
     * Slave datasource queue
     */
    private Queue<DataSource> slave = new ArrayBlockingQueue<>(2);

    /**
     * Queue map
     */
    private final Map<DataSourceType, Queue<DataSource>> DATASOURCE_MAP = new ConcurrentHashMap<>(2);

    /**
     * Create a new {@link DynamicRoutingDataSource}
     *
     * @param master master list
     * @param slave  slave list
     * @param fair   whether fair
     */
    public DynamicRoutingDataSource(BlockingQueue<DataSource> master, BlockingQueue<DataSource> slave, boolean fair) {
        this.fair = fair;
        if (master != null) {
            this.master = master;
        }
        if (slave != null) {
            this.slave = slave;
        }
        DATASOURCE_MAP.put(DataSourceType.MASTER, this.master);
        DATASOURCE_MAP.put(DataSourceType.SLAVE, this.slave);
    }

    /**
     * Create a new {@link DynamicRoutingDataSource}
     *
     * @param master master list
     * @param slave  slave list
     */
    public DynamicRoutingDataSource(BlockingQueue<DataSource> master, BlockingQueue<DataSource> slave) {
        this(master, slave, false);
    }

    @Override
    public Connection getConnection() throws SQLException {
        DataSource datasource = getDatasource(DATASOURCE_MAP.get(DataSourceContext.getDatasourceType()));
        return datasource == null ? null : datasource.getConnection();
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        Assert.hasText(username, "The username is blank");
        Assert.hasText(password, "The password is blank");
        DataSource datasource = getDatasource(DATASOURCE_MAP.get(DataSourceContext.getDatasourceType()));
        return datasource == null ? null : datasource.getConnection(username, password);
    }

    /**
     * Get the datasource from queue
     *
     * @param queue the queue contains datasource
     * @return datasource
     */
    private DataSource getDatasource(Queue<DataSource> queue) {
        DataSource dataSource = null;
        if (queue == null || queue.size() == 0) {
            return dataSource;
        } else if (queue.size() == 1) {
            return queue.peek();
        }
        if (fair) {
            synchronized (DATASOURCE_MAP) {
                dataSource = queue.poll();
                queue.add(dataSource);
            }
        } else {
            dataSource = queue.poll();
            queue.add(dataSource);
        }
        return dataSource;
    }
}
