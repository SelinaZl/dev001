package com.fc.service.impl;

import com.fc.dao.UserMapper;
import com.fc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int del(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Integer id) {
        return userMapper.;
    }
}
