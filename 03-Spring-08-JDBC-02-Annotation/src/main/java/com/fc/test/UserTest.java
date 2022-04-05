package com.fc.test;

import com.fc.config.ApplicationContextConfig;
import com.fc.dao.UserDao;
import com.fc.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class UserTest {
    @Test
    public void testFindAll() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);

        UserDao userDao = applicationContext.getBean(UserDao.class);

        List<User> users = userDao.findAll();

        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindById() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);

        UserDao userDao = applicationContext.getBean(UserDao.class);

        User user = userDao.findById(3);

        System.out.println(user);

    }

    @Test
    public void testCount() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);

        UserDao userDao = applicationContext.getBean(UserDao.class);

        int count = userDao.findCount();

        System.out.println(count);
    }

    @Test
    public void testInsert() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);

        UserDao userDao = applicationContext.getBean(UserDao.class);

        User user = new User();
        user.setUsername("小燕子");
        user.setPassword("7777777");

        int affectedRows = userDao.insert(user);

        System.out.println(affectedRows);

    }

    @Test
    public void testUpdate() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);

        UserDao userdao = applicationContext.getBean(UserDao.class);

        int count = userdao.upDate(new User(3,null, "23455"));

        System.out.println(count);

    }

    @Test
    public void testDelete() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);

        UserDao userDao = applicationContext.getBean(UserDao.class);

        int affectedRows = userDao.delete(9);

        System.out.println(affectedRows);
    }














}
