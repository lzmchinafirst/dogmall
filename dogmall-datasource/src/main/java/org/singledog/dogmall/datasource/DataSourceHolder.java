package org.singledog.dogmall.datasource;

import lombok.Data;
import lombok.ToString;
import org.springframework.util.Assert;

import javax.sql.DataSource;

/**
 * The datasource holder
 *
 * @author ZheMing Liu
 * @since 1.0.0-RELEASE
 */
@Data
@ToString
public class DataSourceHolder {

    /**
     * The target datasource id
     */
    private String id;

    /**
     * The target datasource
     */
    private DataSource dataSource;

    public DataSourceHolder(String id, DataSource dataSource) {
        Assert.hasText(id, "The id in datasource holder is null");
        Assert.notNull(dataSource, "The datasource in datasource holder is null");
        this.dataSource = dataSource;
        this.id = id;
    }
}
