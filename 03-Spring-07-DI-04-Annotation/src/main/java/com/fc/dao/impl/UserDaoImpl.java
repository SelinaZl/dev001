package com.fc.dao.impl;

import com.fc.dao.UserDao;
import com.fc.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> findAll() {
        ArrayList<User> list = new ArrayList();

        list.add(new User(1, "易烊千玺", "123456"));
        list.add(new User(2, "王源", "123456"));
        list.add(new User(3, "王俊凯", "123456"));

        return list;
    }
}
