package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import com.fc.util.MyBatisUtil;
import org.junit.Test;

import java.util.List;

public class AnnotationTest {
    @Test
    public void test() {
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        List<Student> students = studentDao.findAll();

        for (Student student : students) {
            System.out.println(student);
        }

        MyBatisUtil.commit();
    }

    @Test
    public void testFindById() {
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        Student student = studentDao.findById(3);

        System.out.println(student);

        MyBatisUtil.commit();
    }
}