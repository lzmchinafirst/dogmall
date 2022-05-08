package org.singledog.dogmall.datasource;

import javax.sql.DataSource;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * The abstract datasource register
 *
 * @author ZheMing Liu
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
        BlockingQueue<DataSourceHolder> masterQueue = null;
        BlockingQueue<DataSourceHolder> slaveQueue = null;
        if (master != null && master.size() > 0) {
            masterQueue = new ArrayBlockingQueue<>(master.size());
            for (String m : master) {
                DataSourceHolder dataSourceHolder = createDataSourceById(m);
                dataSourceAfterInitial(dataSourceHolder);
                masterQueue.add(dataSourceHolder);
            }
        }
        if (slave != null && slave.size() > 0) {
            slaveQueue = new ArrayBlockingQueue<>(slave.size());
            for (String s : slave) {
                DataSourceHolder dataSourceHolder = createDataSourceById(s);
                dataSourceAfterInitial(dataSourceHolder);
                slaveQueue.add(dataSourceHolder);
            }
        }
        return new DynamicRoutingDataSource(masterQueue, slaveQueue);
    }

    /**
     * Create {@link DataSourceHolder}
     *
     * @param id the datasource id
     * @return {@link DataSourceHolder}
     */
    protected abstract DataSourceHolder createDataSourceById(String id);

    /**
     * Register the {@link DynamicRoutingDataSource},
     * please use it with {@link org.springframework.context.annotation.Bean}
     *
     * @return {@link DynamicRoutingDataSource}
     */
    public abstract DataSource registerDynamicRoutingDataSource();

    /**
     * The method is to extend datasource,
     * rewrite the method if you want to extend your datasource.
     *
     * @param dataSourceHolder hold the target datasource and its id
     */
    protected void dataSourceAfterInitial(DataSourceHolder dataSourceHolder) {

    }
}
