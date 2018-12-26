package com.lzx.service;

import com.lzx.entity.News;

import java.util.List;

public interface NewsService {
    List<News> listAll();
    int addNews(News news);
}
