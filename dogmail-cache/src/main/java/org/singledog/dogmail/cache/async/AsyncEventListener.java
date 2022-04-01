package org.singledog.dogmail.cache.async;

import lombok.extern.slf4j.Slf4j;
import org.singledog.dogmail.cache.annotation.Cache;
import org.singledog.dogmail.core.async.AsyncErrorEvent;
import org.singledog.dogmail.core.async.AsyncErrorEventDescribe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Slf4j
public class AsyncEventListener implements ApplicationListener<AsyncErrorEvent> {

    private RedisTemplate redisTemplate;

    @Autowired
    public AsyncEventListener(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void onApplicationEvent(AsyncErrorEvent event) {
        AsyncErrorEventDescribe asyncDescribe = event.getAsyncDescribe();
        Method method = asyncDescribe.getMethod();
        log.error(asyncDescribe.getEx().getMessage(), asyncDescribe.getEx());
        if (method.isAnnotationPresent(Cache.class)) {
            log.error("The async execute error method is {}", method.getName());
            log.error("Now clean the cache corresponding to the annotation @Cache");
            Cache cache = method.getAnnotation(Cache.class);
            redisTemplate.delete(cache.keyPre() + "*");
            log.error("The {} prefix cache is all deleted",cache.keyPre());
        }
    }
}
