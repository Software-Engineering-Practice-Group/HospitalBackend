package com.example.hospitalbackend.serviceimpl;

import com.example.hospitalbackend.dao.OrderTableDao;
import com.example.hospitalbackend.entity.OrderTable;
import com.example.hospitalbackend.service.OrderTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderTableServiceImpl implements OrderTableService {
    @Autowired
    OrderTableDao orderTableDao;

    /*未实现*/
    @Override
    public List<OrderTable> getOrderByUser(Integer userId) {
        return orderTableDao.getOrderByUser(userId);
    }

    @Override
    public OrderTable addNewOrder(int DoctorId, int PatientId, int rsvTime, int ScheduleId) {
        return orderTableDao.addNewOrder(DoctorId, PatientId, rsvTime, ScheduleId);
    }

}
