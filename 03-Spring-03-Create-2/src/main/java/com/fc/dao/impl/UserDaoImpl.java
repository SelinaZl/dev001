package com.fc.dao.impl;

import com.fc.dao.UserDao;

//通过无参构造创建对象
public class UserDaoImpl implements UserDao {
    private String sqlSession;

    @Override
    public void add() {
        System.out.println("sqlSession调用方法，添加了用户");
    }

    public UserDaoImpl() {
    }
    //添加了一个有参构造
    public UserDaoImpl(String sqlSession) {
        this.sqlSession = sqlSession;
    }
}
