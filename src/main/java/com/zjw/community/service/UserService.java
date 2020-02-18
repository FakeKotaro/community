package com.zjw.community.service;

import com.zjw.community.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void insertUser(User user);

    User findUserByToken(String token);
}
