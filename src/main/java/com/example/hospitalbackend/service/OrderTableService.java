package com.example.hospitalbackend.service;

import com.example.hospitalbackend.entity.OrderTable;

import java.util.List;

public interface OrderTableService {

    OrderTable addNewOrder(int DoctorId, int PatientId, int rsvTime, int ScheduleId);

    //List<OrderTable> getOrderTable(Integer id);
    List<OrderTable> getOrderByUser(Integer userId);
}
