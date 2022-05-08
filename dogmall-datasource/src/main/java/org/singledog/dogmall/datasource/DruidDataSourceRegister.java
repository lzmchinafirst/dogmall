package org.singledog.dogmall.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.List;

/**
 * Druid datasource register
 *
 * @author ZheMing Liu
 * @since 1.0.0-RELEASE
 */
@ConditionalOnProperty(prefix = "routing.datasource", name = "type", havingValue = "druid")
@Configuration(proxyBeanMethods = false)
public class DruidDataSourceRegister extends AbstractDataSourceRegister {

    @Autowired
    private RoutingDataSourceProperties basicProperties;

    @Bean
    @Override
    public DataSource registerDynamicRoutingDataSource() {
        return getDynamicRoutingDatasource(basicProperties.getMaster(), basicProperties.getSlave());
    }

    @Override
    protected DataSourceHolder createDataSourceById(String id) {
        List<RoutingDataSourceProperties.DataSourceCommonMessage> datasourceList = basicProperties.getList();
        if (datasourceList == null || datasourceList.size() == 0) {
            return null;
        }
        for (RoutingDataSourceProperties.DataSourceCommonMessage datasourceCommonMessage : datasourceList) {
            if (StringUtils.equals(id, datasourceCommonMessage.getId())) {
                DruidDataSource dataSource = new DruidDataSource();
                dataSource.setUrl(datasourceCommonMessage.getJdbcUrl());
                dataSource.setUsername(datasourceCommonMessage.getUsername());
                dataSource.setPassword(datasourceCommonMessage.getPassword());
                dataSource.setDriverClassName(datasourceCommonMessage.getDriverClassName());
                return new DataSourceHolder(id, dataSource);
            }
        }
        return null;
    }
}
