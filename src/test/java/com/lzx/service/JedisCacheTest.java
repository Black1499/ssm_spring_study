package com.lzx.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lzx.config.RootConfig;
import com.lzx.dao.NewsMapper;
import com.lzx.entity.News;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import java.io.*;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class JedisCacheTest {

    @Autowired
    private NewsMapper newsMapper;


    @Test
    public void listAllByRedis() {
        Jedis jedis = new Jedis();
        List<News> list = newsMapper.listAll();

        List<String> s = jedis.lrange("news", 0, -1);
        if (s == null) {
            for (News news : list) {
                jedis.lpush("news", news.toString());
            }
            System.out.println("存入到reids中");
        } else {
            System.out.println("从reids中取出");
            s.forEach(System.out::println);
        }
        jedis.close();
    }

    @Test
    public void listAllByJson() throws IOException {
        List<News> list = newsMapper.listAll();
        ObjectMapper objectMapper = new ObjectMapper();
        String key = "news";
        Jedis jedis = new Jedis();
        String listNews = jedis.get(key);
        if (listNews == null || listNews.isEmpty() || "".equals(listNews)) {
            String values = objectMapper.writeValueAsString(list);
            jedis.set(key, values);
            System.out.println("存入缓存");
        } else {
            List<News> newsList = objectMapper.readValue(listNews, new TypeReference<List<News>>(){});
            newsList.forEach(System.out::println);
        }
    }

    @Test
    public void listAllByObjectStream() throws IOException, ClassNotFoundException {
        List<News> list = newsMapper.listAll();
        File f = new File("d:" + File.separator + "redis.txt");

//        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(f));
//        Object[] objects = list.toArray();
//        outputStream.writeObject(objects);
//        outputStream.close();

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(f));
        Object[] objects1 = (Object[]) inputStream.readObject();
        for (Object object : objects1) {
            System.out.println(((News) object).toString());
        }
        inputStream.close();

    }

    @Test
    public void listAllByByteStream() throws IOException, ClassNotFoundException {
        List<News> list = newsMapper.listAll();
        Jedis jedis = new Jedis();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream);
        outputStream.writeObject(list.toArray());

        jedis.set("bnews".getBytes(), byteArrayOutputStream.toByteArray());
        System.out.println(byteArrayOutputStream);
        outputStream.close();


        byte[] buf = jedis.get("bnews".getBytes());
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buf);
        ObjectInputStream inputStream = new ObjectInputStream(byteArrayInputStream);
        Object[] objects = (Object[]) inputStream.readObject();
        for (Object object : objects) {
            System.out.println(((News) object).toString());
        }
        inputStream.close();
    }
}
