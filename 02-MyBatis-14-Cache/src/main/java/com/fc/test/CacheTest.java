package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

public class CacheTest {
    @Test
    public void testTwo() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            Student student1 = studentDao.findById(1);

            System.out.println(student1);

            session.commit();

            Student student2 = studentDao.findById(1);

            System.out.println(student2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            Student student1 = studentDao.findById(2);

            //清除所有缓存
            session.clearCache();

            Student student2 = studentDao.findById(2);

            System.out.println(student1 == student2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}