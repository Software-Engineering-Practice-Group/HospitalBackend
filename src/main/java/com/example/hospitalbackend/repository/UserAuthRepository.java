package com.example.hospitalbackend.repository;

import com.example.hospitalbackend.entity.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserAuthRepository extends JpaRepository<UserAuth,String> {

    @Query(value = "from UserAuth where username = :username and password = :password")
    UserAuth checkUser(@Param("username")String username,@Param("password")String password);

    @Query(value = "from UserAuth where id = :id ")
    UserAuth getById(Integer id);

}
