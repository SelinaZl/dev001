package com.fc.controller;

import com.fc.entity.Clazz;
import com.fc.entity.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping("register")
    public String register(String name, Integer age, String gender, String info) {
        System.out.println(name + " " + age + " " + gender + " " + info);
        //页面跳转路径
        return "/success.jsp";
    }

    @RequestMapping("getNestedBean")
    public String getBean(UserInfo userInfo) {
        System.out.println(userInfo);
        return "/success.jsp";
    }

    @RequestMapping("getListAndMap")
    public String getListAndMap(Clazz clazz) {
        System.out.println(clazz);
        return "/success.jsp";
    }

    @RequestMapping("getRequestParameter")
    public void getRequestParameter(HttpServletRequest request) {
        String username = request.getParameter("username");

        String password = request.getParameter("password");

        System.out.println(username + " " + password);
    }
}
