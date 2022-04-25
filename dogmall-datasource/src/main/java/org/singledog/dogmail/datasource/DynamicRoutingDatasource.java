package org.singledog.dogmail.datasource;

import org.springframework.jdbc.datasource.AbstractDataSource;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Routing datasource
 *
 * @author Zheming Liu
 * @since 1.0.0-RELEASE
 */
public class DynamicRoutingDatasource extends AbstractDataSource {

    private final Queue<DataSource> writeQueue;

    private final Queue<DataSource> readQueue;

    private final Map<DatasourceType, Queue<DataSource>> DATASOURCE_MAP = new ConcurrentHashMap<>(2);

    public DynamicRoutingDatasource(List<DataSource> writeList, List<DataSource> readList) {
        Assert.notEmpty(writeList, "The write queue is empty");
        Assert.notEmpty(readList, "The read queue is empty");
        this.writeQueue = new ArrayBlockingQueue(writeList.size());
        this.readQueue = new ArrayBlockingQueue<>(readList.size());
        writeQueue.addAll(writeList);
        readQueue.addAll(readList);
        DATASOURCE_MAP.put(DatasourceType.WRITE, writeQueue);
        DATASOURCE_MAP.put(DatasourceType.READ, readQueue);
    }

    @Override
    public Connection getConnection() throws SQLException {
        DataSource datasource = getDatasource(DATASOURCE_MAP.get(DatasourceContext.getDatasourceType()));
        return datasource == null ? null : datasource.getConnection();
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        Assert.hasText(username, "The username is blank");
        Assert.hasText(password, "The password is blank");
        DataSource datasource = getDatasource(DATASOURCE_MAP.get(DatasourceContext.getDatasourceType()));
        return datasource == null ? null : datasource.getConnection(username, password);
    }

    private DataSource getDatasource(Queue<DataSource> queue) {
        DataSource dataSource;
        if (queue == null || queue.size() == 0) {
            return null;
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
