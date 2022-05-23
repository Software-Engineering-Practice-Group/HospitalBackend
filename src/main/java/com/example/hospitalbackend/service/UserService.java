package com.example.hospitalbackend.service;

import com.example.hospitalbackend.entity.UserAuth;

public interface UserService {
    UserAuth checkUser(String username, String password);

    UserAuth getById(Integer userId);

    String getNameById(Integer userId);
}
