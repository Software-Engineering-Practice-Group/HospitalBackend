package com.example.hospitalbackend.repository;

import com.example.hospitalbackend.entity.OrderTable;
import com.example.hospitalbackend.entity.ShiftSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface OrderTableRespository extends JpaRepository<OrderTable,Integer> {

    @Query("from OrderTable where user_id=:use_id")
    List<OrderTable> getOrderByUser(Integer use_id);
}
