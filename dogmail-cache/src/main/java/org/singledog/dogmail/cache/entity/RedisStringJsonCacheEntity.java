package org.singledog.dogmail.cache.entity;


import java.util.concurrent.TimeUnit;

public class RedisStringJsonCacheEntity implements CacheEntity<String, Object> {

    private String keyPre;

    private String key;

    private Object value;

    private Long timeOut;

    private TimeUnit timeUnit;

    public RedisStringJsonCacheEntity(String keyPre, String key, Object value, Long timeOut, TimeUnit timeUnit) {
        this.keyPre = keyPre;
        this.key = key;
        this.value = value;
        this.timeOut = timeOut;
        this.timeUnit = timeUnit;
    }

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
