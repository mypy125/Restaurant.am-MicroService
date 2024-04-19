package com.example.user.service;

import com.example.user.entity.User;

public interface UserService {
    User findUserByJwtToken(String jwt)throws Exception;
    User findUserByEmail(String email)throws Exception;
    void doSomething();
}
