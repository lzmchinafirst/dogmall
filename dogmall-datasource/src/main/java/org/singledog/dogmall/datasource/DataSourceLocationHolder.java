package org.singledog.dogmall.datasource;

import lombok.Data;
import lombok.ToString;
import org.springframework.util.Assert;

/**
 * The datasource location
 *
 * @author ZheMing Liu
 * @see DataSourceLocationMode
 * @since 1.0.0-RELEASE
 */
@Data
@ToString
public class DataSourceLocationHolder {

    /**
     * The key for the location
     */
    private String key;

    /**
     * The mode for the location
     */
    private DataSourceLocationMode mode;

    public DataSourceLocationHolder(String key, DataSourceLocationMode mode) {
        Assert.hasText(key, "The datasource location key is null");
        Assert.notNull(mode, "The datasource location mode is null");
        this.mode = mode;
        this.key = key;
    }
}
