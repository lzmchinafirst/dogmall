package org.singledog.dogmall.redis.bean;

import lombok.*;

import java.util.concurrent.TimeUnit;

/**
 * Redis redis,the key serial type is String,the value serial type is json
 *
 * @author Zheming Liu
 * @see CacheEntity
 * @since 1.0.0-RELEASE
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RedisStringJsonCacheEntity implements CacheEntity<String, Object> {

    /**
     * Cache key prefix
     */
    private String keyPre;

    /**
     * Cache key
     */
    private String key;

    /**
     * Cache value
     */
    private Object value;

    /**
     * Cache live time
     */
    private Long timeOut;

    /**
     * Cache live time unit
     */
    private TimeUnit timeUnit;

    @Override
    public String getKey() {
        return keyPre + key;
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public Object setValue(Object value) {
        return this.value = value;
    }
}
