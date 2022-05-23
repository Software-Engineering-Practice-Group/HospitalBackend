package com.example.hospitalbackend.dao;
import com.example.hospitalbackend.entity.UserAuth;

public interface UserDao {
    UserAuth checkUser(String username,String password);

    UserAuth getById(Integer userId);


}
