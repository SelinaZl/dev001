package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import com.fc.util.MyBatisUtil;
import org.junit.Test;

import java.util.List;

public class DynamicSqlTest {
    @Test
    public void testFindAll() {
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        List<Student> students = studentDao.findAll();

        for (Student student : students) {
            System.out.println(student);
        }

        MyBatisUtil.commit();
    }

    @Test
    public void testFindByKeyword() {
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        List<Student> students = studentDao.findByKeyword("%天%", 15);

        for (Student student : students) {
            System.out.println(student);
        }

        MyBatisUtil.commit();
    }

    @Test
    public void testFindByStudent() {
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        Student student = new Student();
        student.setId(2);
        student.setName("小小天");
        student.setGender("女");

        List<Student> students = studentDao.findByStudent(student);

        for (Student temp : students) {
            System.out.println(temp);
        }
    }

    @Test
    public void testUpdate() {
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        Student student = new Student();
        student.setId(4);
        student.setName("秃林");
        student.setGender("男");
        student.setInfo("18号");
        int affectedRows = studentDao.update(student);

        System.out.println("受影响的行数" + affectedRows);

        MyBatisUtil.commit();
    }

    @Test
    public void testFindByStudentOnTrim() {
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        Student student = new Student();
        student.setId(2);

        List<Student> students = studentDao.findByStudentOnTrim(student);

        for (Student temp : students) {
            System.out.println(temp);
        }
    }

    @Test
    public void testUpdateOnTrim() {
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        Student student = new Student();

        student.setId(9);
        student.setName("芭比");
        student.setAge(11);
        student.setGender("女");
        student.setInfo("芭比公主");

        int affectedRows = studentDao.updateOnTrim(student);

        System.out.println("受影响的行数：" + affectedRows);

        MyBatisUtil.commit();
    }

    @Test
    public void testDeleteMore() {
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        int affectedRows = studentDao.deleteMore(21, 20);

        System.out.println("受影响的行数:" + affectedRows);

        MyBatisUtil.commit();
    }
}