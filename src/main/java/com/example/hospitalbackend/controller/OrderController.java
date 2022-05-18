package com.example.hospitalbackend.controller;


import com.example.hospitalbackend.entity.OrderTable;
import com.example.hospitalbackend.service.OrderTableService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderTableService orderTableService;

    @RequestMapping("/addOrder")
    OrderTable AddNewOrder(@RequestBody JSONObject order){
        int DoctorId=order.getInt("DoctorName");
        int PatientId=order.getInt("PatientName");
        int rsvTime=order.getInt("rsvTime");
        int ScheduleId=order.getInt("ScheduleId");

        OrderTable newOrder = orderTableService.AddNewOrder(DoctorId,PatientId, rsvTime, ScheduleId);
        return newOrder;
    }
}
