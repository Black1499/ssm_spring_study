package com.lzx.service;


import com.lzx.config.RootConfig;
import com.lzx.entity.News;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class NewsCacheServiceImplTest {

    @Autowired
    private NewsService newsCacheService;

    @Test
    public void listAll() {
        System.out.println(newsCacheService.listAll());
    }

    @Test
    public void addNews() {
        newsCacheService.addNews(new News("debug", "学坏debug调试程序叭叭叭吧"));
    }

    @Test
    public void getNewsById() {
        System.out.println(newsCacheService.getNewsById(1));
    }
}
