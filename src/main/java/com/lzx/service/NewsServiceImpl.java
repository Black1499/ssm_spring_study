package com.lzx.service;

import com.lzx.dao.NewsMapper;
import com.lzx.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

// @Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    //@Cacheable("listNews")
    public List<News> listAll() {
        return newsMapper.listAll();
    }

    @Override
    public int addNews(News news) {
        return newsMapper.insertNews(news);
    }

    @Override
    public News getNewsById(int id) {
        return newsMapper.getById(id);
    }

}
