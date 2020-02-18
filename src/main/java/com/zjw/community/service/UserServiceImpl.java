package com.zjw.community.service;

import com.zjw.community.domain.User;
import com.zjw.community.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public User findUserByToken(String token) {
        return userMapper.findUserByToken(token);
    }
}
