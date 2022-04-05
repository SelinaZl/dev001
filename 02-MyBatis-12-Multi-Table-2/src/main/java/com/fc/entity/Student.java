package com.fc.entity;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private String info;
    private List<Subject> subjects;
}
