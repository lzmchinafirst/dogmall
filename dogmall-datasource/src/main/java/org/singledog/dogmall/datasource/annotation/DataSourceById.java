package org.singledog.dogmall.datasource.annotation;

import java.lang.annotation.*;

/**
 * Find the datasource by id
 *
 * @author ZheMing Liu
 * @since 1.0.0-RELEASE
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSourceById {
    /**
     * The datasource id
     */
    String value();
}
