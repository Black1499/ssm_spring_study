package com.lzx.service;


import com.lzx.config.RootConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class NewsServiceTest {

    @Autowired
    private NewsService newsService;

    @Test
    public void listAll() {
        newsService.listAll();
    }

    @Test
    public void addNews() {
    }
}
