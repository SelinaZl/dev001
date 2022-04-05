package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping("hello")
    public String hello() {
        System.out.println("hello");
        return "hello";
    }

    @RequestMapping("login")
    public String login() {
        System.out.println("login");
        return "login";
    }

    @RequestMapping("update")
    public String update() {
        System.out.println("update");
        return "update";
    }

    @RequestMapping("delete")
    public String delete() {
        System.out.println("delete");
        return "delete";
    }
}
