package com.fc.test;

import com.fc.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Create2Test {
    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao userDao = applicationContext.getBean("userDao", UserDao.class);

        userDao.add();
    }

    @Test
    public void testTwo() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao userDao2 = applicationContext.getBean("userDao2", UserDao.class);

        userDao2.add();

    }

    @Test
    public void testThree() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao userDao = applicationContext.getBean("userDao3", UserDao.class);

        userDao.add();
    }
}
