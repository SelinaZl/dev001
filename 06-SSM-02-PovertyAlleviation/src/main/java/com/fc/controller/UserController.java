package com.fc.controller;

import com.fc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("del")
    public Map<String, Object> del(Long id) {

        Map<String, Object> map = new HashMap<>();

        int affectedRows = userService.del(id);

        if (affectedRows > 0) {
            map.put("message", "用户删除成功！");
            map.put("code", 200);
            map.put("success", true);
            map.put("data", null);
        } else {
            map.put("message", "用户删除失败！");
            map.put("code", 404);
            map.put("success", false);
            map.put("data", "错误描述");
        }
        return map;
    }

    @RequestMapping("update")
    public Map<String, Object> update(Integer id) {
        Map<Object, Object> map = new HashMap<>();

        userService.update(id);

    }
}
