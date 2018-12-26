package com.lzx.service;

import com.lzx.dao.NewsMapper;
import com.lzx.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Autowired
    private JedisService jedisService;

    @Override
    public List<News> listAll() {
        Jedis jedis = new Jedis();
        List<News> list = newsMapper.listAll();
        List<String> s = jedis.lrange("news", 0, -1);
        if (s == null) {
            for (News news : list) {
                jedis.lpush("news", news.toString());
            }
        } else {
            s.forEach(System.out::println);
        }
        jedis.close();

        return newsMapper.listAll();
    }

    @Override
    public int addNews(News news) {
        return newsMapper.insertNews(news);
    }
}
