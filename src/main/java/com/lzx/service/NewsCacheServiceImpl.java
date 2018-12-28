package com.lzx.service;

import com.lzx.dao.NewsMapper;
import com.lzx.entity.News;
import com.lzx.redis.MyKeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsCacheServiceImpl implements NewsService {

    @Autowired
    private NewsMapper mapper;

    @Override
    @Cacheable("listNews")
    public List<News> listAll() {
        return mapper.listAll();
    }

    @Override
    @CachePut("listNews")
    public int addNews(News news) {
        return mapper.insertNews(news);
    }

    @Override
    @CachePut(keyGenerator = "myKeyGenerator", value = "news_id:")
    public News getNewsById(int id) {
        return mapper.getById(1);
    }
}
