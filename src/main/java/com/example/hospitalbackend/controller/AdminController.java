package com.example.hospitalbackend.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.hospitalbackend.entity.*;
import com.example.hospitalbackend.entity.OrderTable;
import com.example.hospitalbackend.repository.DoctorRespository;
import com.example.hospitalbackend.repository.ShiftScheduleRepository;
import com.example.hospitalbackend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/*管理员控制：主要完成管理员的相关操作，譬如修改信息、指定排班表等，*/
@RestController
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private ShiftScheduleService shiftScheduleService;
    @Autowired
    private DoctorRespository doctorRespository;
    @Autowired
    private ShiftScheduleRepository shiftScheduleRepository;
    @Autowired
    private DepartmentService departmentService;

    /**
     * changeDocImg
     * @param param
     * @return com.example.hospitalbackend.entity.Doctor
     * @Author: Kiddo on 2022/5/23
     */
    @RequestMapping("/changeDocImg")
    Doctor changeDocImg(@RequestBody JSONObject param){
        Integer docId = param.getInteger("doctor_id");
        String newImg = param.getString("image");
        Doctor doc = doctorRespository.getById(docId);
        doc.setImage(newImg);
        doctorRespository.save(doc);
        return doctorRespository.getById(docId);
    }
    /**
     * changeDocName
     * @param param
     * @return com.example.hospitalbackend.entity.Doctor
     * @Author: Kiddo on 2022/5/23
     */
    @RequestMapping("/changeDocName")
    Doctor changeDocName(@RequestBody JSONObject param){
        Integer docId = param.getInteger("doctor_id");
        String newName = param.getString("new_name");
        Doctor doc = doctorRespository.getById(docId);
        doc.setName(newName);
        doctorRespository.save(doc);
        return doctorRespository.getById(docId);
    }
    /**
     * changeDocTitle
     * @param param
     * @return com.example.hospitalbackend.entity.Doctor
     * @Author: Kiddo on 2022/5/23
     */
    @RequestMapping("/changeDocTitle")
    Doctor changeDocTitle(@RequestBody JSONObject param){
        Integer docId = param.getInteger("doctor_id");
        String newTitle = param.getString("new_title");
        Doctor doc = doctorRespository.getById(docId);
        doc.setTitle(newTitle);
        doctorRespository.save(doc);
        return doctorRespository.getById(docId);
    }
    /**
     * changeDocInfo
     * @param param
     * @return com.example.hospitalbackend.entity.Doctor
     * @Author: Kiddo on 2022/5/23
     */
    @RequestMapping("/changeDocInfo")
    Doctor changeDocInfo(@RequestBody JSONObject param){
        Integer docId = param.getInteger("doctor_id");
        String newInfo = param.getString("new_info");
        Doctor doc = doctorRespository.getById(docId);
        doc.setInfo(newInfo);
        doctorRespository.save(doc);
        return doctorRespository.getById(docId);
    }
    /**
     * changeDocPsw
     * @param param
     * @return com.example.hospitalbackend.entity.Doctor
     * @Author: Kiddo on 2022/5/23
     */
    @RequestMapping("/changeDocPsw")
    Doctor changeDocPsw(@RequestBody JSONObject param){
        Integer docId = param.getInteger("doctor_id");
        String newPsw = param.getString("new_password");
        Doctor doc = doctorRespository.getById(docId);
        doc.setPassword(newPsw);
        doctorRespository.save(doc);
        return doctorRespository.getById(docId);
    }

    /**
     * changeDocCapacityByTime
     *
     * @param param
     * @return com.example.hospitalbackend.entity.ShiftSchedule
     * @Author: Kiddo on 2022/5/23
     */
    @RequestMapping("/changeDocCapacityByTime")
    ShiftSchedule changeDocCapacityByTime(@RequestBody JSONObject param) throws ParseException {
        Integer docId = param.getInteger("doctor_id");
        //String 转 Date
        String date_1 = param.getString("date");
        SimpleDateFormat da = new SimpleDateFormat("yyyy-MM-dd");
        Date date = da.parse(date_1);
        Integer time = param.getInteger("time");
        Integer newCapacity = param.getInteger("new_capacity");
        ShiftSchedule sche = shiftScheduleService.getByDocIdAndDate(docId, date);
        switch (time) {
            case 2:
                sche.setTime2(newCapacity);
                break;
            case 3:
                sche.setTime3(newCapacity);
                break;
            case 4:
                sche.setTime4(newCapacity);
                break;
            default:
                sche.setTime1(newCapacity);
                break;
        }
        System.out.println(sche);
//        shiftScheduleRepository.save(sche);
        return shiftScheduleService.getByDocIdAndDate(docId, date);
    }

}
