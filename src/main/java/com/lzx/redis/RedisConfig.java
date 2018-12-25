package com.lzx.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
@ComponentScan(basePackages = "com.lzx.redis")
public class RedisConfig {
    @Bean
    public JedisConnectionFactory redisConnectionFactoryConfig(){
        JedisConnectionFactory factory = new JedisConnectionFactory();
        return factory;
    }

    @Bean
    public RedisTemplate redisTemplateConfig(){
        return new StringRedisTemplate(this.redisConnectionFactoryConfig());
    }

}
