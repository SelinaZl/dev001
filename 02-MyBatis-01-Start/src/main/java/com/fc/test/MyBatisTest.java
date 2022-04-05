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
    public void testAdd() {

        try {
            //读取配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            //获取工厂对象
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            //获取连接
            SqlSession session = factory.openSession();

            //执行指定的sql语句
            int affectedRows = session.insert("StudentMapper.add");

            //所有的增删改操作都需要提交
            session.commit();

            System.out.println("受影响的行数：" +affectedRows);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelect() {
        try {
            //读取配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            //获取sqlSession工厂对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //获取sqlSession，这个东西就类似于queryRunner。包含了所有对数据库的操作
            SqlSession session = sqlSessionFactory.openSession();

            //执行指定命名空间下的指定sql语句
            Student student = (Student) session.selectOne("StudentMapper.select");

            System.out.println(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDao() {

        try {
            //读取配置
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            //获取sqlSession工厂对象
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            //获取数据库连接
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
    public void testAddOnDao() {

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
    public void testFindById() {
        try {
            //读取配置
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            //获取工厂对象
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            //获取数据库连接
            SqlSession session = factory.openSession();

            //获取接口实现类对象
            StudentDao studentDao = session.getMapper(StudentDao.class);

            //获取接口实现类对象
            Student student = studentDao.findById(5);

            System.out.println(student);

            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
