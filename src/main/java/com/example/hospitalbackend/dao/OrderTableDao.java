package com.example.hospitalbackend.dao;

import com.example.hospitalbackend.entity.OrderTable;

import java.util.List;

public interface OrderTableDao {
    OrderTable addNewOrder(int DoctorId, int PatientId, int rsvTime, int ScheduleId, String info);

    List<OrderTable> getOrderByUser(Integer userId);
}
