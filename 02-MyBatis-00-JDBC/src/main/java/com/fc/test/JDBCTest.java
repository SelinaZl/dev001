package com.fc.test;

import com.fc.entity.Student;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;

public class JDBCTest {
    @Test
    public void testQuery() {
        //加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");

            //准备参数
            String url = "jdbc:mysql://localhost:3306/rx2003?useSSL=false&useUnicode=true&characterEncoding=UTF8&serverTimezone=Asia/Shanghai";
            String username = "root";
            String password = "root";
            String sql = "select * from student";

            //获取连接
            Connection connection = DriverManager.getConnection(url, username, password);

            //获取预处理的搬运工对象
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //执行sql语句，获取结果集
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Student> students = new ArrayList<>();

            //遍历结果集
            while (resultSet.next()) {
                Student student = new Student();

                //获取每一个字段对应的值封装到学生对象中
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                student.setGender(resultSet.getString("gender"));
                student.setInfo(resultSet.getString("info"));

                students.add(student);
            }

            for (Student student : students) {
                System.out.println(student);
            }


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void textQuery2() {

        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            //准备参数
            String url = "jdbc:mysql://localhost:3306/rx2003?useSSL=false&useUnicode=true&characterEncoding=UTF8&serverTimezone=Asia/Shanghai";
            String username = "root";
            String password = "root";
            String sql = "select * from student";

            //获取连接
            Connection connection = DriverManager.getConnection(url, username, password);

            //获取预处理的搬运工对象
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //执行sql语句，获取结果集
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Student> students = new ArrayList<>();

            //遍历结果集
            while (resultSet.next()) {
                Student student = new Student();

                //获取每一个字段对应的值封装到学生对象中
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                student.setGender(resultSet.getString("gender"));
                student.setInfo(resultSet.getString("info"));

                students.add(student);
            }

            for (Student student : students) {
                System.out.println(student);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void textQuery3() {

        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            //准备参数
            String url = "jdbc:mysql://localhost:3306/rx2003?useSSL=false&useUnicode=true&characterEncoding=UTF8&serverTimezone=Asia/Shanghai";
            String username = "root";
            String password = "root";
            String sql = "select * from student";

            //获取连接
            Connection connection = DriverManager.getConnection(url, username, password);

            //获取预处理搬运工对象
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //执行sql语句，获取结果集
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Student> students = new ArrayList<>();

            //遍历结果集
            while (resultSet.next()) {
                Student student = new Student();

                //获取每一个字段对应的值封装到学生对象中
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                student.setGender(resultSet.getString("gender"));
                student.setInfo(resultSet.getString("info"));

                students.add(student);
            }
            for (Student student : students) {
                System.out.println(student);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testAdd() {
        //加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");

            //准备参数
            String url = "jdbc:mysql://localhost:3306/rx2003?useSSL=false&useUnicode=true&characterEncoding=UTF8&serverTimezone=Asia/Shanghai";
            String username = "root";
            String password = "root";
            String sql = "insert into student(name, age, gender, info) values (?, ?, ?, ?)";

            //获取连接
            Connection connection = DriverManager.getConnection(url, username, password);

            //获取预处理的搬运工对象
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //设置参数
            preparedStatement.setObject(1, "王瑶瑶");
            preparedStatement.setObject(2, 16);
            preparedStatement.setObject(3, "女");
            preparedStatement.setObject(4, "大脸妹");

            //获取受影响的行数
            int affectedRows = preparedStatement.executeUpdate();

            System.out.println("受影响的行数：" + affectedRows);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAdd2() {
        //加载驱动
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            //准备参数
            String url = "jdbc:mysql://localhost:3306/rx2003?useSSL=false&useUnicode=true&characterEncoding=UTF8&serverTimezone=Asia/Shanghai";
            String username = "root";
            String password = "root";
            String sql = "insert into student(name, age, gender, info) VALUES (?, ?, ?, ?)";

            //获取连接
            Connection connection = DriverManager.getConnection(url, username, password);

            //获取预处理的搬运工对象
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setObject(1, "张佳蓓");
            preparedStatement.setObject(2, 8);
            preparedStatement.setObject(3, "女");
            preparedStatement.setObject(4, "张日天的妹妹");
            //执行sql语句，获取受影响的行数
            int affectedRows = preparedStatement.executeUpdate();

            System.out.println("受影响的行数：" + affectedRows);


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testAdd3() {

        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            //准备参数
            String url = "jdbc:mysql://localhost:3306/rx2003?useSSL=false&useUnicode=true&characterEncoding=UTF8&serverTimezone=Asia/Shanghai";
            String username = "root";
            String password = "root";
            String sql = "insert into student(name, age, gender, info) VALUES (?, ?, ?, ?)";

            //获取连接
            Connection connection = DriverManager.getConnection(url, username, password);

            //获取预处理搬运工
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, "林北星");
            preparedStatement.setObject(2, 23);
            preparedStatement.setObject(3, "女");
            preparedStatement.setObject(4, "循环");
            //获取受影响行数
            int affectedRows = preparedStatement.executeUpdate();

            System.out.println("受影响的行数为：" + affectedRows);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
