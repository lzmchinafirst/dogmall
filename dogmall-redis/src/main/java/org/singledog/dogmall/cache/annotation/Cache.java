package org.singledog.dogmall.cache.annotation;

import org.singledog.dogmall.cache.entity.RedisStringJsonCacheEntity;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * Redis cache,enhancer by spring AOP
 *
 * @author Zheming Liu
 * @since 1.0.0-RELEASE
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Cache {

    /**
     * Cache key pre
     */
    String keyPre();

    /**
     * Cache key
     */
    String key();

    /**
     * Cache value
     */
    String value();

    /**
     * Cache live time
     */
    long expire() default -1;

    /**
     * Cache live time unit
     */
    TimeUnit expireTimeUnit() default TimeUnit.SECONDS;

    /**
     * Whether create random expire time
     */
    boolean expireWhetherRandom() default false;

    /**
     * Whether delay delete
     */
    boolean whetherDelay() default false;

    /**
     * If delay delete,the delay time to execute
     */
    long delayTime() default -1;

    /**
     * If delay delete,the delay time unit to execute
     */
    TimeUnit delayTimeUnit() default TimeUnit.MILLISECONDS;

    /**
     * Default redis cache entity
     */
    Class<?> type() default RedisStringJsonCacheEntity.class;
}
