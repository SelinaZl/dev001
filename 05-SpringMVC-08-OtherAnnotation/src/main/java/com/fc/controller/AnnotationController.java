package com.fc.controller;

import com.fc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("annotation")
public class AnnotationController {
    @RequestMapping("testRequestParam")
    public String testRequestParam(@RequestParam(value = "userId") String id) {

        System.out.println("从前端获取到的请求参数：" + id);

        return "/success.jsp";
    }

    @RequestMapping("page")
    public String page(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {

        System.out.println("当前页：" + pageNo + "，每页显示多少条数据：" + pageSize);
        return "/success.jsp";
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public String getUser(@PathVariable String id) {

        System.out.println("查询id为" + id + "的学生");

        return "/success.jsp";
    }

    @RequestMapping(value = "testJsonObject", consumes = "application/json; charset=UTF-8")
    @ResponseBody
    public void testJsonObject(@RequestBody User user) {
        System.out.println(user);

    }
}
