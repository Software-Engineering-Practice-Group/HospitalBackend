package com.example.hospitalbackend.serviceimpl;


import com.example.hospitalbackend.dao.UserDao;
import com.example.hospitalbackend.entity.Users;
import com.example.hospitalbackend.service.UserService;
import com.example.hospitalbackend.utils.msgutils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Users checkUser(String account, String passwoed){
        return userDao.checkUser(account,passwoed);
    }

    @Override
    public Users getById(Integer userId){return userDao.getById(userId);}

    @Override
    public String getNameById(Integer userId){
        Users tmp = userDao.getById(userId);
        return tmp.getUsername();
    }


    @Override
    public Msg register(String username, String password, String tel, String email, Integer gender) {
        Msg msg =userDao.checkUserDup(username);
        if(msg.getStatus()<0)
            return msg;
        System.out.println(email);
        return userDao.register(username,password,tel,email,gender);
    }

}
