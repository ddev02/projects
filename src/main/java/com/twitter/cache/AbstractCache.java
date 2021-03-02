package com.twitter.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> implements Cache<K, V> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<K, V> map;

	public AbstractCache() {
		super();
		this.map = new LinkedHashMap<K, V>();
	}

	public Map<K, V> load() {

		return null;
	}

	public void updateCache(K k, V v) {

		map.putIfAbsent(k, v);

	}

	public V get(K k) {

		return map.get(k);
	}
}
