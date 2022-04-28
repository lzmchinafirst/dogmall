package org.singledog.dogmall.cache.annotation;

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
public @interface DistributeLock {
}
