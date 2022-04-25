package org.singledog.dogmail.datasource;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ToString
@ConfigurationProperties(prefix = RoutingDatasourceProperties.PREFIX, ignoreInvalidFields = true)
public class RoutingDatasourceProperties {
    public static final String PREFIX = "routing.datasource";

    private String type;

    private List<String> writeDatasource;

    private List<DatasourceCatalogue> catalogue;

    @Data
    @ToString
    public static class DatasourceCatalogue {
        private String id;
        private String driverClassName;
        private String jdbcUrl;
        private String username;
        private String password;
    }
}
