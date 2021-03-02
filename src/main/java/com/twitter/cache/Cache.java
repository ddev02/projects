package com.twitter.cache;

import java.io.Serializable;
import java.util.Map;

import com.twitter.exception.InValidCacheName;

public interface Cache<K, V> extends Serializable {

	public String getName() throws InValidCacheName;

	public Map<K, V> load();

	public void updateCache(K k, V v);

	public V get(K k);
}
