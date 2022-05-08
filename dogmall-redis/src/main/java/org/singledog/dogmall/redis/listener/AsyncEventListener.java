package org.singledog.dogmall.redis.listener;

import lombok.extern.slf4j.Slf4j;
import org.singledog.dogmall.redis.annotation.Cache;
import org.singledog.dogmall.core.async.AsyncErrorEvent;
import org.singledog.dogmall.core.async.AsyncErrorEventDescribe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * The listener to monitor the exception from {@link org.springframework.scheduling.annotation.Async} method
 *
 * @author Zheming Liu
 * @since 1.0.0-RELEASE
 */
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
            log.error("The listener execute error method is {}", method.getName());
            log.error("Now clean the redis corresponding to the annotation @Cache");
            Cache cache = method.getAnnotation(Cache.class);
            redisTemplate.delete(cache.keyPre() + "*");
            log.error("The {} prefix redis is all deleted", cache.keyPre());
        }
    }
}
