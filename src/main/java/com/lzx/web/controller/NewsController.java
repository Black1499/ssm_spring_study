package com.lzx.web.controller;

import com.lzx.entity.News;
import com.lzx.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class NewsController {
    @Autowired
    NewsService newsService;

    @GetMapping("/news")
    @ResponseBody
    public List<News> newsList(){
        return newsService.listAll();
    }
}
