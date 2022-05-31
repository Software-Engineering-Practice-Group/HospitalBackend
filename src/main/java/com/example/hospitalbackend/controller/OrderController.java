package com.example.hospitalbackend.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.hospitalbackend.constant.Constant;
import com.example.hospitalbackend.entity.Department;
import com.example.hospitalbackend.entity.OrderTable;
import com.example.hospitalbackend.service.DepartmentService;
import com.example.hospitalbackend.service.DoctorService;
import com.example.hospitalbackend.service.OrderTableService;
import com.example.hospitalbackend.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class OrderController {

    @Autowired
    private OrderTableService orderTableService;
    @Autowired
    private UserService userService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private DepartmentService departmentService;


    /*
     *
     * @Description: 增加新的预约单
     * @param order
     * @return com.example.hospitalbackend.entity.OrderTable
     * @author 赵熙
     * @date 2022/5/23 19:34
     */
    @RequestMapping("/addOrder")
    OrderTable addNewOrder(@RequestBody JSONObject order){
        int DoctorId=order.getInt("DoctorName");
        int PatientId=order.getInt("PatientName");
        int rsvTime=order.getInt("rsvTime");
        int ScheduleId=order.getInt("ScheduleId");

        OrderTable newOrder = orderTableService.addNewOrder(DoctorId,PatientId, rsvTime, ScheduleId);
        return newOrder;
    }

    /**
     * @Description: getOrderByUser
     * @Param: <int>userId
     * @return: JSON.toJSONString(
     * [ {“ name ” : ” 张三 ” ，“ date ” : ” 日期 ”,“ time ” : “ 挂号具体时间段 ” ，
     *“ deptName ” : “ 科室名称 ”,“ doctorName ” : 医生姓名 ，
     *“ info ” : “ 病情描述 ” ，” process ” : “ 流程 ”},
     * {“name”:”张三” ，“date”:”日期” ,“time” : “挂号具体时间段” ，
     * “deptName” : “科室名称” ,“doctorName” :医生姓名 ，
     *  “info”: “病情描述” ，”process” : “流程”}])
     * @Author: Kiddo
     */
    @RequestMapping("/getOrderByUser")
    String getOrderByUser(@RequestBody Map<String,Integer> params){
        Integer userId=params.get(Constant.USER_ID);
        List<OrderTable> orders=orderTableService.getOrderByUser(userId);
        JSONArray allOrder=new JSONArray();
        for(int i=0;i<orders.size();++i){
            JSONObject singleOrder=new JSONObject();
            OrderTable tmpOrder=orders.get(i);
            singleOrder.put("name",userService.getNameById(tmpOrder.getUser_id()));
            singleOrder.put("date",tmpOrder.getDate());
            singleOrder.put("time",tmpOrder.getTime());
            singleOrder.put("deptName",doctorService.getDepById(tmpOrder.getDoctor_id()));
            singleOrder.put("doctorName",doctorService.getNameById(tmpOrder.getDoctor_id()));
            singleOrder.put("info",tmpOrder.getInfo());

            Integer process=tmpOrder.getProcess();
            Department dep=departmentService.getByName(doctorService.getDepById(tmpOrder.getDoctor_id()));
            switch (process){
                case 2:
                    singleOrder.put("process",dep.getProcess2());
                    break;
                case 3:
                    singleOrder.put("process",dep.getProcess3());
                    break;
                case 4:
                    singleOrder.put("process",dep.getProcess4());
                    break;
                default:
                    singleOrder.put("process",dep.getProcess1());
                    break;
            }
            System.out.println("ok");

            allOrder.add(singleOrder);
        }
        return JSON.toJSONString(allOrder);
    }

}
