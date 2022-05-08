package org.singledog.dogmall.redis.annotation;

import org.singledog.dogmall.redis.bean.RedisStringJsonCacheEntity;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * Redis redis,enhancer by spring AOP
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
     * The delay delete model
     */
    String delayModel() default "normal";

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
     * Default redis redis entity
     */
    Class<?> type() default RedisStringJsonCacheEntity.class;
}
