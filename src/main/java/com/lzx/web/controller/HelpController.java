package com.lzx.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Objects;

@Controller
public class HelpController {

    //在子容器中 注入一个 WebApplicationContext 的实例
    @Autowired
    private WebApplicationContext webApplicationContext;

    @RequestMapping(path = "/ioc", method = RequestMethod.GET)
    @ResponseBody
    public HashMap<String, String[]> allInIoc() {
        return new HashMap<String, String[]>() {{
            put("子容器", webApplicationContext.getBeanDefinitionNames());
            put("父容器", Objects.requireNonNull(webApplicationContext.getParent()).getBeanDefinitionNames());
        }};
    }
}