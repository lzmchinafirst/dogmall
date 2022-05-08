package org.singledog.dogmall.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.HikariJNDIFactory;
import org.singledog.dogmall.datasource.advisor.DataSourceAdvisor;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Routing datasource auto configuration,
 * you can extend your datasource type.
 *
 * @author ZheMing Liu
 * @since 1.0.0-RELEASE
 */
@Import(DataSourceAdvisor.class)
@EnableConfigurationProperties(RoutingDataSourceProperties.class)
@Configuration(proxyBeanMethods = false)
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
public class RoutingDataSourceAutoConfiguration {

    /**
     * Configure druid datasource
     */
    @Configuration(proxyBeanMethods = false)
    @ConditionalOnClass({DruidDataSource.class, DruidDataSourceFactory.class})
    @Import(DruidDataSourceRegister.class)
    static class DruidRoutingDataSourceConfiguration {

    }

    /**
     * Configure hikari datasource
     */
    @Configuration(proxyBeanMethods = false)
    @ConditionalOnClass({HikariDataSource.class, HikariJNDIFactory.class})
    @Import(HikariDataSourceRegister.class)
    static class HikariRoutingDataSourceConfiguration {

    }
}
