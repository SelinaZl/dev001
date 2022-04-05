package com.fc.dao;

import com.fc.entity.Student;
import org.apache.ibatis.annotations.Param;

import javax.xml.crypto.Data;
import java.util.Map;

public interface StudentDao {
    Student findById(Integer id);

    Student findByIdAndName(@Param("id") Integer id, @Param("name") String name);

    Student findByIdAndGender(Map<String, Object> map);

    int insert(Student student);
}
