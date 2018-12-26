package com.lzx.dao;



import com.lzx.config.RootConfig;
import com.lzx.entity.News;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class NewsMapperTest {

    @Autowired
    private NewsMapper newsMapper;

    @Test
    public void listAll() {
        newsMapper.listAll();
    }

    @Test
    public void insertNews() {
        newsMapper.insertNews(new News("你所不知道的12月25日","1870年12月25日八国联军火烧圆明园"));
    }
}
