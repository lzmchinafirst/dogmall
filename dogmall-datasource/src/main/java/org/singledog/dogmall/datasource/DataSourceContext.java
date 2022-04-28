package org.singledog.dogmall.datasource;

/**
 * DataSource context
 *
 * @author Zheming Liu
 * @since 1.0.0-RELEASE
 */
public class DataSourceContext {

    /**
     * DataSource context
     */
    private static final ThreadLocal<DataSourceType> DATASOURCE_CONTEXT = ThreadLocal.withInitial(() -> DataSourceType.MASTER);


    /**
     * Return the datasource type
     *
     * @return datasource type
     */
    public static DataSourceType getDatasourceType() {
        return DATASOURCE_CONTEXT.get();
    }

    /**
     * Reset the datasource type
     *
     * @param type datasource type {@link DataSourceType}
     */
    public static void setDatasourceType(DataSourceType type) {
        DATASOURCE_CONTEXT.set(type);
    }

    /**
     * Remove the datasource
     */
    public static void removeDatasource() {
        DATASOURCE_CONTEXT.remove();
    }
}
