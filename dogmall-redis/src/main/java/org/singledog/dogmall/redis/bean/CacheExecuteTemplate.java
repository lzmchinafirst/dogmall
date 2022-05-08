package org.singledog.dogmall.redis.bean;

import java.util.Collection;

public interface CacheExecuteTemplate<T> {
    void addCache(T cache);

    void addAll(Collection<T> caches);

    boolean deleteCache(String key);

    boolean deleteAll(String key);
}
