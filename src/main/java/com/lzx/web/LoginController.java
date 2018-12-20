package com.lzx.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {



    @GetMapping("/login/{name}")
    public String login(@PathVariable("name") String name, HttpSession session) {
        session.setAttribute("admin", name);
        return "redirect:/emp";
    }

}
