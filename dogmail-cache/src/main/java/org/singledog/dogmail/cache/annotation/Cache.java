package org.singledog.dogmail.cache.annotation;

import org.singledog.dogmail.cache.entity.RedisStringJsonCacheEntity;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Cache {

    String keyPre();

    String key();

    String value();

    long expire() default -1;

    TimeUnit expireTimeUnit() default TimeUnit.SECONDS;

    boolean expireWhetherRandom() default false;

    boolean whetherDelay() default false;

    long delayTime() default -1;

    TimeUnit delayTimeUnit() default TimeUnit.MILLISECONDS;

    Class<?> type() default RedisStringJsonCacheEntity.class;
}
