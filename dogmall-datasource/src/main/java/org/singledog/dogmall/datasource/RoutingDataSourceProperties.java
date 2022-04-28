package org.singledog.dogmall.datasource;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * The {@link DynamicRoutingDataSource} config properties
 *
 * @author Zheming Liu
 * @since 1.0.0-RELEASE
 */
@Data
@ToString
@ConfigurationProperties(prefix = RoutingDataSourceProperties.PREFIX, ignoreInvalidFields = true)
public class RoutingDataSourceProperties {
    public static final String PREFIX = "routing.datasource";

    private String type;

    private List<String> master;

    private List<String> slave;

    private List<DataSourceCommonMessage> list;

    @Data
    @ToString
    public static class DataSourceCommonMessage {
        private String id;
        private String driverClassName;
        private String jdbcUrl;
        private String username;
        private String password;
    }
}
