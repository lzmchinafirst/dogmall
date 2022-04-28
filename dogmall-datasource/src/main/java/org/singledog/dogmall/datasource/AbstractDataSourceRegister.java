package org.singledog.dogmall.datasource;

import javax.sql.DataSource;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * The abstract datasource register
 *
 * @author Zheming Liu
 * @since 1.0.0-RELEASE
 */
public abstract class AbstractDataSourceRegister {

    /**
     * Get {@link DynamicRoutingDataSource}
     *
     * @param master master datasource list
     * @param slave  slave datasource list
     * @return {@link DynamicRoutingDataSource}
     */
    protected DataSource getDynamicRoutingDatasource(List<String> master, List<String> slave) {
        BlockingQueue<DataSource> masterQueue = null;
        BlockingQueue<DataSource> slaveQueue = null;
        if (master != null && master.size() > 0) {
            masterQueue = new ArrayBlockingQueue<>(master.size());
            for (String m : master) {
                masterQueue.add(createDataSourceById(m));
            }
        }
        if (slave != null && slave.size() > 0) {
            slaveQueue = new ArrayBlockingQueue<>(slave.size());
            for (String s : slave) {
                masterQueue.add(createDataSourceById(s));
            }
        }
        return new DynamicRoutingDataSource(masterQueue, slaveQueue);
    }

    /**
     * Create target datasource by id
     *
     * @param id the datasource id
     * @return {@link DataSource}
     */
    protected abstract DataSource createDataSourceById(String id);

    /**
     * Register the {@link DynamicRoutingDataSource},please use it with {@link org.springframework.context.annotation.Bean}
     *
     * @return {@link DynamicRoutingDataSource}
     */
    public abstract DataSource registerDynamicRoutingDataSource();
}
