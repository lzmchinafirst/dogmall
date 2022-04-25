package org.singledog.dogmail.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Druid datasource register
 *
 * @author Zheming Liu
 * @since 1.0.0-RELEASE
 */
@ConditionalOnProperty(prefix = "routing.datasource", name = "type", havingValue = "druid")
@Configuration(proxyBeanMethods = false)
public class DruidDatasourceRegister {

    /**
     * Register routing datasource,the son datasource's type is Druid
     *
     * @return routing datasource {@link DynamicRoutingDatasource}
     */
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Bean
    public DataSource registerDatasource(RoutingDatasourceProperties basicProperties) {
        List<RoutingDatasourceProperties.DatasourceCatalogue> datasourceCatalogue = basicProperties.getCatalogue();
        DynamicRoutingDatasource dynamicRoutingDatasource = null;
        if (datasourceCatalogue != null && datasourceCatalogue.size() > 0) {
            List<DataSource> writeList = new ArrayList<>(2);
            List<DataSource> readList = new ArrayList<>(2);
            List<String> writeDatasource = basicProperties.getWriteDatasource();
            for (RoutingDatasourceProperties.DatasourceCatalogue info : datasourceCatalogue) {
                DruidDataSource dataSource = new DruidDataSource();
                dataSource.setUrl(info.getJdbcUrl());
                dataSource.setUsername(info.getUsername());
                dataSource.setPassword(info.getPassword());
                dataSource.setDriverClassName(info.getDriverClassName());
                if (writeDatasource != null && writeDatasource.size() > 0 && writeDatasource.contains(info.getId())) {
                    writeList.add(dataSource);
                } else {
                    readList.add(dataSource);
                }
            }
            dynamicRoutingDatasource = new DynamicRoutingDatasource(writeList, readList);
        }
        return dynamicRoutingDatasource;
    }
}
