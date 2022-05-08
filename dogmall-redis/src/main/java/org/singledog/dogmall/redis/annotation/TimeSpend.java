package org.singledog.dogmall.redis.annotation;

import java.lang.annotation.*;

/**
 * Record the proxy method time spend
 *
 * @author Zheming Liu
 * @since 1.0.0-RELEASE
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TimeSpend {
}
