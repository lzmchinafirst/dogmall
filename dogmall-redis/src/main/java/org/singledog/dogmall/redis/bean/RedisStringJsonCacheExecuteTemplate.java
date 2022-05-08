package org.singledog.dogmall.redis.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.Collection;

@Component
public class RedisStringJsonCacheExecuteTemplate implements CacheExecuteTemplate<RedisStringJsonCacheEntity> {

    private RedisTemplate redisTemplate;

    @Autowired
    public RedisStringJsonCacheExecuteTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void addCache(RedisStringJsonCacheEntity cache) {
        addAll(Arrays.asList(cache));
    }

    @Override
    public boolean deleteCache(String key) {
        return redisTemplate.delete(key);
    }

    @Override
    public void addAll(Collection<RedisStringJsonCacheEntity> caches) {
        Assert.notEmpty(caches, "The cache is null");
        for (RedisStringJsonCacheEntity cache : caches) {
            if (cache.getTimeOut() != null && cache.getTimeUnit() != null) {
                redisTemplate.opsForValue().set(cache.getKey(), cache.getValue(), cache.getTimeOut(), cache.getTimeUnit());
            } else {
                redisTemplate.opsForValue().set(cache.getKey(), cache.getValue());
            }
        }
    }

    @Override
    public boolean deleteAll(String key) {
        return redisTemplate.delete(key + "*");
    }
}
