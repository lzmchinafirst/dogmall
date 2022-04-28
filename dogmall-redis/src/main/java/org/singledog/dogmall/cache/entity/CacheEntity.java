package org.singledog.dogmall.cache.entity;

import java.util.Map;

/**
 * Cache entity
 *
 * @param <K> the cache key
 * @param <V> the cache value
 * @author Zheming Liu
 * @see java.util.Map.Entry
 * @since 1.0.0-RELEASE
 */
public interface CacheEntity<K, V> extends Map.Entry<K, V> {
}
