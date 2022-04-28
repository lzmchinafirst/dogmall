package org.singledog.dogmall.datasource;

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
public class DynamicRoutingDataSource extends AbstractDataSource {

    private final Queue<DataSource> master;

    private final Queue<DataSource> slave;

    private final Map<DataSourceType, Queue<DataSource>> DATASOURCE_MAP = new ConcurrentHashMap<>(2);

    public DynamicRoutingDataSource(BlockingQueue<DataSource> master, BlockingQueue<DataSource> slave) {
        this.master = master == null ? new LinkedBlockingQueue<>(0) : master;
        this.slave = slave == null ? new LinkedBlockingDeque<>(0) : slave;
        DATASOURCE_MAP.put(DataSourceType.MASTER, this.master);
        DATASOURCE_MAP.put(DataSourceType.SLAVE, this.slave);
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

    private DataSource getDatasource(Queue<DataSource> queue) {
        DataSource dataSource = null;
        if (queue == null || queue.size() == 0) {
            return dataSource;
        } else if (queue.size() == 1) {
            return queue.peek();
        }
        synchronized (DATASOURCE_MAP) {
            dataSource = queue.poll();
            queue.add(dataSource);
        }
        return dataSource;
    }
}
