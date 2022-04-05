package com.fc.dao;

import com.fc.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    List<Student> findAll();

    List<Student> findByKeyword(@Param("name") String name, @Param("age") Integer age);

    //根据条件查询学生
    List<Student> findByStudent(Student student);

    //修改学生
    int update(Student student);

    //根据条件查询学生trim标签
    List<Student> findByStudentOnTrim(Student student);

    //用trim修改学生
    int updateOnTrim(Student student);

    //删除多个
    // 不定长参数、可变长参数，可以传递的参数个数0个1个或者多个
    //只能用作形参列表中最后一个参数的位置，并且只能有一个
    int deleteMore(Integer... ids);
}
