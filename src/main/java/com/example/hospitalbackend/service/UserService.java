package com.example.hospitalbackend.service;

import com.example.hospitalbackend.entity.UserAuth;

public interface UserService {
    UserAuth checkUser(String username, String password);

}
