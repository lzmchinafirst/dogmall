package org.singledog.dogmall.datasource.annotation;

import java.lang.annotation.*;

/**
 * Find datasource by type
 *
 * @author ZheMing Liu
 * @since 1.0.0-RELEASE
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSourceByMS {
    /**
     * Two types,master and slave
     */
    String value() default "master";
}
