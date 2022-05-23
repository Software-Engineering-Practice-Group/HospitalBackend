package com.example.hospitalbackend.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.hospitalbackend.entity.Doctor;
import com.example.hospitalbackend.entity.ShiftSchedule;
import com.example.hospitalbackend.service.DoctorService;
import com.example.hospitalbackend.service.ShiftScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class ScheduleController {

    @Autowired
    private ShiftScheduleService shiftScheduleService;
    @Autowired
    private DoctorService doctorService;

    /**
     * @Description: getTodayScheByDep
     * @Param: date, department
     * @return: JSON.toJSONString([
     *     {“image” : “url”, “name” : “张锋”,  “title” : “专家“ ，“info”：“blabla”, “doctor_capacity” : 10 ，“time”: 1},
     *     {...}
     * ])
     * @Author: Kiddo
     */
    @RequestMapping("/getTodayScheByDep")
    public String getTodayScheByDep(@RequestBody JSONObject infos) throws ParseException {
        //String 转 Date
        String date_1=infos.getString("date");
        SimpleDateFormat da=new SimpleDateFormat("yyyy-MM-dd");
        Date date=da.parse(date_1);
        System.out.println(date);
        String department = infos.getString("department");

        JSONArray allSche=new JSONArray();
        List<ShiftSchedule> todayDocs= shiftScheduleService.getShiftSchedulesByDate(date);
        for(Integer i=0;i< todayDocs.size();++i){
            Doctor doc=doctorService.getDoctorById(todayDocs.get(i).getDoctor_id());
            if(doc.getDepartment().equals(department)){
                JSONObject singleSche1=new JSONObject();
                singleSche1.put("image",doc.getImage());
                singleSche1.put("name",doc.getName());
                singleSche1.put("title",doc.getTitle());
                singleSche1.put("info",doc.getInfo());
                singleSche1.put("doctor_capacity",todayDocs.get(i).getTime1());
                singleSche1.put("time",1);
                JSONObject singleSche2=new JSONObject();
                singleSche2.put("image",doc.getImage());
                singleSche2.put("name",doc.getName());
                singleSche2.put("title",doc.getTitle());
                singleSche2.put("info",doc.getInfo());
                singleSche2.put("doctor_capacity",todayDocs.get(i).getTime2());
                singleSche2.put("time",2);
                JSONObject singleSche3=new JSONObject();
                singleSche3.put("image",doc.getImage());
                singleSche3.put("name",doc.getName());
                singleSche3.put("title",doc.getTitle());
                singleSche3.put("info",doc.getInfo());
                singleSche3.put("doctor_capacity",todayDocs.get(i).getTime3());
                singleSche3.put("time",3);
                JSONObject singleSche4=new JSONObject();
                singleSche4.put("name",doc.getName());
                singleSche4.put("title",doc.getTitle());
                singleSche4.put("info",doc.getInfo());
                singleSche4.put("doctor_capacity",todayDocs.get(i).getTime4());
                singleSche4.put("time",4);
                allSche.add(singleSche1);
                allSche.add(singleSche2);
                allSche.add(singleSche3);
                allSche.add(singleSche4);

            }

        }
        return JSON.toJSONString(allSche);
    }
}
