package com.example.hospitalbackend.daoimpl;


import com.example.hospitalbackend.dao.UserDao;
import com.example.hospitalbackend.entity.UserAuth;
import com.example.hospitalbackend.repository.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    UserAuthRepository userAuthRepository;

    @Autowired
    UserAuthRepository userRepository;

    public UserAuth checkUser(String usrername,String password){
        return userAuthRepository.checkUser(usrername,password);
    }


}
