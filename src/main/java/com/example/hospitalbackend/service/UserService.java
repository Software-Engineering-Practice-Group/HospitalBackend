package com.example.hospitalbackend.service;

import com.example.hospitalbackend.entity.Users;
import com.example.hospitalbackend.utils.msgutils.Msg;

public interface UserService {
    Users checkUser(String account, String password);

    Users getById(Integer userId);

    String getNameById(Integer userId);

    Msg register(String username, String password, String tel, String email, Integer gender);
}
