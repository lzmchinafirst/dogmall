package org.singledog.dogmail.cache.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.concurrent.TimeUnit;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RedisStringJsonCacheEntity implements CacheEntity<String, Object> {

    private String keyPre;

    private String key;

    private Object value;

    private Long timeOut;

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
