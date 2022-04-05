package com.fc.controller;

import com.fc.controller.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @RequestMapping("register")
    public Map<String, Object> register(User user) {
        System.out.println(user);

        Map<String, Object> map = new HashMap<>();

        map.put("code", 200);
        map.put("message", "注册成功");
        map.put("success", true);
        map.put("data", "姐姐");

        return map;
    }
}
