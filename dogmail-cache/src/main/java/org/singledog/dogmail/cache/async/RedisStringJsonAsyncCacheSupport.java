package org.singledog.dogmail.cache.async;

import org.singledog.dogmail.cache.entity.RedisStringJsonCacheEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class RedisStringJsonAsyncCacheSupport implements AsyncCacheAddSupport<RedisStringJsonCacheEntity> {

    private RedisTemplate redisTemplate;

    @Autowired
    public RedisStringJsonAsyncCacheSupport(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Async
    @Override
    public void addCache(RedisStringJsonCacheEntity cache) {
        redisTemplate.opsForValue().set(cache.getKey(), cache.getValue());
    }
}
