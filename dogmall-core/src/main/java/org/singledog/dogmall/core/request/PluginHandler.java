package org.singledog.dogmall.core.request;

/**
 * The plugin handler.
 *
 * @param <T> plugin type
 * @author ZheMing Liu
 * @since 1.0.0-RELEASE
 */
@FunctionalInterface
public interface PluginHandler<T> {

    /**
     * Handle plugin
     *
     * @param plugin target plugin
     */
    void handlePlugin(T plugin);
}
