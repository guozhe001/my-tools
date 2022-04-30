package com.nicai.ehcache.demo.config;

import net.sf.ehcache.config.CacheConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author guozhe
 */
@EnableCaching
@Configuration
public class EhcacheConfig {

    @Bean
    public CacheManager cacheManager() {
        return new EhCacheCacheManager(ehCacheManager());
    }

    @Bean
    public net.sf.ehcache.CacheManager ehCacheManager() {
        net.sf.ehcache.config.Configuration configuration = new net.sf.ehcache.config.Configuration();
        configuration.setDefaultCacheConfiguration(new CacheConfiguration("hello", 1024 * 1024));
        return new net.sf.ehcache.CacheManager(configuration);
    }

}
