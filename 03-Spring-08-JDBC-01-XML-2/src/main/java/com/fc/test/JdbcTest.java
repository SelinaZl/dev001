package com.fc.test;

import com.fc.dao.UserDao;
import com.fc.entity.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class JdbcTest {
    @Test
    public void test() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao userDao = applicationContext.getBean(UserDao.class);

        List<User> users = userDao.findAll();

        for (User user : users) {
            System.out.println(user);
        }
    }
}
