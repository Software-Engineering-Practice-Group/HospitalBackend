package com.example.hospitalbackend.controller;

import com.example.hospitalbackend.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class PatientController {
    @Autowired
    private UserService userService;

//    /*
//     *
//     * @Description: 返回患者订单信息
//     * @param params
//     * @return net.sf.json.JSONObject
//     * @author 赵熙
//     * @date 2022/5/30 9:40
//     * {
//        “name”:”患者姓名” ，
//        “date”:”日期” ,
//        “time” : “挂号具体时间段” ，
//        “deptName” : “科室名称” ,
//        “doctorName” :医生姓名 ，
//        “info”: “病情描述” ，
//        ”process” : “流程”
//        }
//
//     */
//    @RequestMapping("/getUserOrders")
//    List<JSONObject> getAllOrders(@RequestBody Map<String, String> params) {
//        return userService.getAllOrders();
//    }
}
