package com.lzx.service;


import com.lzx.config.RootConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class NewsServiceImplTest {

    @Autowired
    private NewsService newsService;

    @Test
    public void listAll() {
        System.out.println(newsService.listAll());
    }

    @Test
    public void addNews() {
    }

    @Test
    public void getById() {
        newsService.getNewsById(1);
    }
}
