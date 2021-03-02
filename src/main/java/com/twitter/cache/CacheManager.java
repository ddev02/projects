package com.twitter.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.twitter.exception.InValidCacheName;

public class CacheManager {

	private Map<String, Cache<Object, Object>> map;

	private CacheManager() {

		this.map = new ConcurrentHashMap<String, Cache<Object, Object>>();
	}

	private static CacheManager cacheManager = new CacheManager();

	public static CacheManager getCacheManager() {

		return cacheManager;
	}

	public void registerCache(Cache<Object, Object> cache) throws InValidCacheName{
		
		map.put(cache.getName(), cache);
	}
	
	
	public Cache<Object, Object> getCache(String name) {

		return map.get(name);
	}
}
