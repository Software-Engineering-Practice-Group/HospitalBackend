package com.example.hospitalbackend.dao;
import com.example.hospitalbackend.entity.Users;
import com.example.hospitalbackend.utils.msgutils.Msg;

public interface UserDao {
    Users checkUser(String username, String password);

    Users getById(Integer userId);


    Msg checkUserDup(String username);

    Msg register(String username, String password, String tel, String email, Integer gender);
}
