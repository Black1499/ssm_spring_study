package com.lzx.service;

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
    public void listAllByFile() throws IOException, ClassNotFoundException {
        List<News> list = newsMapper.listAll();
        File f = new File("d:" + File.separator + "redis.text");
        if(!f.exists()){
            f.createNewFile();
        }

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(f));
        FileInputStream fileInputStream = new FileInputStream(f);
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);

        if (fileInputStream.getChannel().size() == 4){

            Object[] objects = list.toArray();
            outputStream.writeObject(objects);
            outputStream.close();
        } else {
            Object[] objects = (Object[]) inputStream.readObject();
            for (Object object : objects) {
                System.out.println(((News) object).toString());
            }
            inputStream.close();
        }
    }
}
