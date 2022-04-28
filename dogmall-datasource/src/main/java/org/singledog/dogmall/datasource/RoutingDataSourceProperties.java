package org.singledog.dogmall.datasource;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * The {@link DynamicRoutingDataSource} config properties,the son class
 * {@link DataSourceCommonMessage} is just a common configuration,if you
 * want to extend the {@link javax.sql.DataSource} function,please define
 * the configuration and change the register like {@link HikariDataSourceRegister}
 *
 * @author Zheming Liu
 * @since 1.0.0-RELEASE
 */
@Data
@ToString
@ConfigurationProperties(prefix = RoutingDataSourceProperties.PREFIX, ignoreInvalidFields = true)
public class RoutingDataSourceProperties {

    public static final String PREFIX = "routing.datasource";

    /**
     * The datasource type,the default datasource for spring is hikari
     */
    private String type;

    /**
     * The master datasource list
     */
    private List<String> master;

    /**
     * The slave datasource list
     */
    private List<String> slave;

    /**
     * The {@link DataSourceCommonMessage} list
     */
    private List<DataSourceCommonMessage> list;

    /**
     * The datasource common message
     */
    @Data
    @ToString
    public static class DataSourceCommonMessage {

        /**
         * The datasource id
         */
        private String id;

        /**
         * The datasource driver class name
         */
        private String driverClassName;

        /**
         * The datasource jdbc url,like jdbc:mysql://host:port/schema?param=result...
         */
        private String jdbcUrl;

        /**
         * The datasource username
         */
        private String username;

        /**
         * The datasource password
         */
        private String password;
    }
}
