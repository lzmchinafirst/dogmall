package org.singledog.dogmall.datasource;

/**
 * Datasource location context
 *
 * @author ZheMing Liu
 * @since 1.0.0-RELEASE
 */
public class DataSourceLocationContext {

    /**
     * The context hold datasource location
     */
    private static final ThreadLocal<DataSourceLocationHolder> DATASOURCE_CONTEXT = ThreadLocal.withInitial(() -> new DataSourceLocationHolder("master", DataSourceLocationMode.MS));


    /**
     * Return the datasource location
     *
     * @return {@link DataSourceLocationHolder}
     */
    public static DataSourceLocationHolder getDataSourceLocation() {
        return DATASOURCE_CONTEXT.get();
    }

    /**
     * Reset the datasource location
     *
     * @param holder datasource location holder
     */
    public static void setDatasourceType(DataSourceLocationHolder holder) {
        DATASOURCE_CONTEXT.set(holder);
    }

    /**
     * Remove the datasource location
     */
    public static void removeDatasource() {
        DATASOURCE_CONTEXT.remove();
    }
}
