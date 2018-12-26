package com.lzx.service;

import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Service
public class JedisServiceImpl  implements JedisService {
    private Jedis jedis = null;

    @Override
    public String jedisGetListValues(String key) {
        jedis = new Jedis();
        return jedis.lpop(key);
    }

    @Override
    public void jedisSet(String key, String value) {
        jedis = new Jedis();
        jedis.lpush(key,value);
    }
}
