package com.lzx.service;


import redis.clients.jedis.Jedis;

public interface JedisService {

    String jedisGetListValues(String key);

    void jedisSet(String key, String value);
}
