package com.lzx.redis;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
@ComponentScan(basePackages = "com.lzx.redis")
@EnableCaching
public class RedisConfig {
    @Bean
    public JedisConnectionFactory redisConnectionFactoryConfig() {
        return new JedisConnectionFactory();
    }

    @Bean
    public RedisTemplate redisTemplateConfig() {
//        RedisTemplate<Object, Object> template = new RedisTemplate<>();
//        template.setDefaultSerializer(new JdkSerializationRedisSerializer());
        return new StringRedisTemplate(this.redisConnectionFactoryConfig());
    }

    @Bean("cacheManager")
    public CacheManager cacheManagerConfig() {
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration
                .defaultCacheConfig()
                .computePrefixWith(cacheName -> "lzx." + cacheName)
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.string()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.json()));

        return RedisCacheManager.builder(redisConnectionFactoryConfig()).cacheDefaults(redisCacheConfiguration).build();
    }
}
