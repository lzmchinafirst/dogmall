package org.singledog.dogmall.redis.annotation;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

/**
 * Redis distribute lock,enhancer by spring AOP
 *
 * @author Zheming Liu
 * @since 1.0.0-RELEASE
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Order(Ordered.LOWEST_PRECEDENCE - 3)
public @interface DistributeLock {

}
