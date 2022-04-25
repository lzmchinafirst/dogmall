package org.singledog.dogmail.datasource;

/**
 * Datasource context
 *
 * @author Zheming Liu
 * @since 1.0.0-RELEASE
 */
public class DatasourceContext {

    /**
     * Datasource context
     */
    private static final ThreadLocal<DatasourceType> DATASOURCE_CONTEXT = ThreadLocal.withInitial(() -> DatasourceType.WRITE);


    /**
     * Return the datasource type
     *
     * @return datasource type
     */
    public static DatasourceType getDatasourceType() {
        return DATASOURCE_CONTEXT.get();
    }

    /**
     * Reset the datasource type
     *
     * @param type datasource type {@link DatasourceType}
     */
    public static void setDatasourceType(DatasourceType type) {
        DATASOURCE_CONTEXT.set(type);
    }

    /**
     * Remove the datasource
     */
    public static void removeDatasource() {
        DATASOURCE_CONTEXT.remove();
    }
}
