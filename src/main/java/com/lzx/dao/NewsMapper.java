package com.lzx.dao;

import com.lzx.entity.News;
import org.springframework.stereotype.Repository;

import javax.enterprise.inject.New;
import java.util.List;

@Repository
public interface NewsMapper {
    List<News> listAll();

    int insertNews(News news);

    News getById(int id);
}

