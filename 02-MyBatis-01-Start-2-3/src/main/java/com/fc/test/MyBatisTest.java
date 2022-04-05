package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTest {
    @Test
    public void testDao2() {

        try {
            //读取配置
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            //获取工厂对象
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            //获取连接
            SqlSession session = factory.openSession();

            //获取接口的实现类对象
            StudentDao studentDao = session.getMapper(StudentDao.class);

            Student student = studentDao.selectOne();

            System.out.println(student);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDao3() {
        try {
            //读取配置
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //获取sql工厂对象
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            //获取连接
            SqlSession session = factory.openSession();
            //获取接口实现类对象
            StudentDao studentDao = session.getMapper(StudentDao.class);
            Student student = studentDao.selectOne();
            System.out.println(student);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAddOnDao2() {
        try {
            //读取配置
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            //获取工厂对象
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            //获取连接
            SqlSession session = factory.openSession();

            //获取接口实现类对象
            StudentDao studentDao = session.getMapper(StudentDao.class);

            //调取接口中的方法
            int affectedRows = studentDao.add();

            session.commit();
            session.close();

            System.out.println("受影响的行数：" + affectedRows);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAddOnDao3() {
        try {
            //读取配置
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            //获取工厂对象
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            //获取数据库连接
            SqlSession session = factory.openSession();

            //获取接口实现类对象
            StudentDao studentDao = session.getMapper(StudentDao.class);

            //调取接口实现类中的方法
            int affectedRows = studentDao.add();

            session.commit();
            session.close();

            System.out.println(affectedRows);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindById2() {
        //读取配置
        try {
            //读取配置
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            //获取工厂对象
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            //获取连接
            SqlSession session = factory.openSession();

            //获取实现类对象
            StudentDao studentDao = session.getMapper(StudentDao.class);

            //调取实现类中接口方法
            Student student = studentDao.findById(11);

            System.out.println(student);

            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testFindById() {
        try {
            //读取配置
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            //获取工厂对象
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            //获取连接
            SqlSession session = factory.openSession();

            //获取实现类对象
            StudentDao studentDao = session.getMapper(StudentDao.class);

            //调取实现类中接口方法
            Student student = studentDao.findById(7);

            System.out.println(student);

            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
