package com.fc.test;

import com.fc.controller.UserController;
import com.fc.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserTest {
    @Test
    public void testUser() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

    }

    @Test
    public void testAnnotation() {
        //通过注解获取Spring容器
        //必须配置包扫描路径，会扫描指定包下的所有注解
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.fc");

        User user = applicationContext.getBean(User.class);

        System.out.println(user);
    }

    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserController controller = applicationContext.getBean(UserController.class);

        List<User> list = controller.findAll();

        System.out.println(list);
    }
}
