package com.fc.entity;

public class Student {
    private Integer id;
    private String name;
    private Byte age;

    public Student() {
        System.out.println("无参构造被执行~~~~~");
    }

    private void eat() {
        System.out.println("起来就吃");
    }

    private void sleep() {
        System.out.println("吃完就睡");
    }
}
