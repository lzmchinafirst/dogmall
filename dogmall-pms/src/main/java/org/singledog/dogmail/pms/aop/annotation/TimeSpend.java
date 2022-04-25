package org.singledog.dogmail.pms.aop.annotation;

import java.lang.annotation.*;

/**
 * Method spend time
 *
 * @author Zheming Liu
 * @since 1.0.0-RELEASE
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TimeSpend {
}
