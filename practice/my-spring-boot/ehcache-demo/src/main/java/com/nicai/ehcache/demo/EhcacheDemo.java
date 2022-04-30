package com.nicai.ehcache.demo;

import lombok.extern.slf4j.Slf4j;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.springframework.stereotype.Service;

/**
 * @author guozhe
 */
@Slf4j
@Service
public class EhcacheDemo {

    private final CacheManager cacheManager;

    public EhcacheDemo(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public void print() {
        cacheManager.addCacheIfAbsent("cache_test");
        Cache cache = cacheManager.getCache("cache_test");

        cache.put(new Element("firstCode", "第一个元素"));

        Element firstCode = cache.get("firstCode");
        log.info("hello ehcache my first cache is ={}", firstCode);

    }

}
