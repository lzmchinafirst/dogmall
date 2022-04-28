package org.singledog.dogmall.datasource;

import java.lang.annotation.*;

/**
 * DataSource type annotation
 *
 * @author Zheming Liu
 * @since 1.0.0-RELEASE
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {
    DataSourceType value() default DataSourceType.MASTER;
}
