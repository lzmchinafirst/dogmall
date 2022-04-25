package org.singledog.dogmail.datasource;

import java.lang.annotation.*;

/**
 * Datasource type annotation
 *
 * @author Zheming Liu
 * @since 1.0.0-RELEASE
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Datasource {
    DatasourceType value() default DatasourceType.WRITE;
}
