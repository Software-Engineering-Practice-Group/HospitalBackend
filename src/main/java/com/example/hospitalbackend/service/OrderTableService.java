package com.example.hospitalbackend.service;

import com.example.hospitalbackend.entity.OrderTable;

import java.util.List;

public interface OrderTableService {

    OrderTable AddNewOrder(int DoctorId, int PatientId, int orderNum, int ScheduleId);

    //List<OrderTable> getOrderTable(Integer id);
    List<OrderTable> getOrderTableByPid(Integer id);
}
