package com.lzx.web.controller;

import com.lzx.entity.User;
import com.lzx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login/{name}")
    public String loginByUrl(@PathVariable("name") String name, HttpSession session) {
        session.setAttribute("admin", new User(name));
        return "redirect:/emp";
    }


    @PostMapping("/login")
    public String login(User user, HttpSession session) {
        User users = userService.login(user);
        if (users != null) {
            session.setAttribute("admin", users);
            return "redirect:/emp";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping
    public String loginIndex() {
        return "login";
    }
}
