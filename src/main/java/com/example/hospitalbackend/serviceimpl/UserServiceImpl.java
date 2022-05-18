package com.example.hospitalbackend.serviceimpl;


import com.example.hospitalbackend.dao.UserDao;
import com.example.hospitalbackend.entity.UserAuth;
import com.example.hospitalbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserAuth checkUser(String username,String passwoed){
        return userDao.checkUser(username,passwoed);
    }
}
