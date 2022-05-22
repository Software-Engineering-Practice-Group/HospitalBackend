package com.example.hospitalbackend.controller;

import com.example.hospitalbackend.constant.Constant;
import com.example.hospitalbackend.entity.Department;
import com.example.hospitalbackend.service.DepartmentService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    /**
     * @Description: getAllDepartment
     * @Param: null
     * @return: JSON.toJSONString(
     * [ {“name” : “儿童口腔科”,”intro”:”xxx”},
     * {“name” : “口腔全科门诊, ”intro”:”xxx”} ,
     * {“name” : “口腔正畸科”, ”intro”:”xxx”} ]
     * )
     * @Author: Kiddo
     */
    @RequestMapping("/getAllDepartment")
    public String getAllDepartment(){

        JSONArray allDep=new JSONArray();
        List<Department> departments= departmentService.getDepartments();
        for(Integer i=0;i< departments.size();++i){
            JSONObject singleDep=new JSONObject();
            singleDep.put("name",departments.get(i).getName());
            singleDep.put("intro",departments.get(i).getIntro());
            allDep.add(singleDep);
        }
        return JSON.toJSONString(allDep);
    }
}
