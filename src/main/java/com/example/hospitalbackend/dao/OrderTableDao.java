package com.example.hospitalbackend.dao;

import com.example.hospitalbackend.entity.OrderTable;

public interface OrderTableDao {
    OrderTable AddNewOrder(int DoctorId,int PatientId, int orderNum,int ScheduleId);
}
