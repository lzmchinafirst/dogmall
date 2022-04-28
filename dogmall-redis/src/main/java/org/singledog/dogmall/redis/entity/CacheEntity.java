package org.singledog.dogmall.redis.entity;

import java.util.Map;

/**
 * Cache entity
 *
 * @param <K> the redis key
 * @param <V> the redis value
 * @author Zheming Liu
 * @see java.util.Map.Entry
 * @since 1.0.0-RELEASE
 */
public interface CacheEntity<K, V> extends Map.Entry<K, V> {
}
