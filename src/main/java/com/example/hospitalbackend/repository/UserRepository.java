package com.example.hospitalbackend.repository;

import com.example.hospitalbackend.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<Users,String> {

    @Query(value = "from Users where tel = :account and password = :password")
    Users checkUser(@Param("account")String account, @Param("password")String password);

    @Query(value = "from Users where id = :id ")
    Users getById(Integer id);

    @Query(value ="from Users where username = ?1")
    Users checkUserDup(String username);

}
