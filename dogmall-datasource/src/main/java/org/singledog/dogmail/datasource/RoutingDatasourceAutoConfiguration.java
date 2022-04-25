package org.singledog.dogmail.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Routing datasource auto configuration,
 * you can extend your datasource type.
 *
 * @author Zheming Liu
 * @since 1.0.0-RELEASE
 */
@Import(DatasourceContext.class)
@EnableConfigurationProperties(RoutingDatasourceProperties.class)
@Configuration(proxyBeanMethods = false)
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
public class RoutingDatasourceAutoConfiguration {

    /**
     * Config druid datasource
     */
    @Configuration(proxyBeanMethods = false)
    @ConditionalOnClass({DruidDataSource.class, DruidDataSourceFactory.class})
    @Import(DruidDatasourceRegister.class)
    static class DruidRoutingDatasourceConfiguration {

    }
}
