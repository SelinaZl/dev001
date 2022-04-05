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
import java.util.List;

public class CRUDTest {
    /*查询全部*/
    @Test
    public void testFindAll() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session =  factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            List<Student> students = studentDao.findAll();

            for (Student student : students) {
                System.out.println(student);
            }

            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*通过id查询*/
    @Test
    public void testFindById() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            Student student = studentDao.findById(12);

            System.out.println(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*插入*/
    @Test
    public void testInsert() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            Student student = new Student();

            student.setName("爱笑的小乌堆");
            student.setAge(12);
            student.setGender("男");
            student.setInfo("我是小乌龟");
            int affectedRows = studentDao.insert(student);

            System.out.println("受影响的行数：" + affectedRows);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*删除*/
    @Test
    public void testDelete() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            int affectedRows = studentDao.delete(21);

            System.out.println("受影响的行数：" + affectedRows);

            session.commit();

            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*修改*/
    @Test
    public void testUpdate() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            Student student = new Student();

            student.setId(28);
            student.setInfo("12345");

            int affectedRows = studentDao.update(student);

            System.out.println("受影响的行数：" + affectedRows);

            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*模糊查询*/
    @Test
    public void testKeyword() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            List<Student> students = studentDao.findByKeyword("%小%");

            for (Student student : students) {
                System.out.println(student);
            }

            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*主键回填*/
    @Test
    public void testGetAutoIncrement() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            Student student = new Student();

            student.setName("年福兰");
            student.setAge(30);
            student.setGender("女");
            student.setInfo("婉婉");
            int affectedRows = studentDao.getAutoIncrement(student);

            System.out.println("受影响的行数：" + affectedRows);
            System.out.println("自增长的id：" + student.getId());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
