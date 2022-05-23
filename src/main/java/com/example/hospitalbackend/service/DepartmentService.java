package com.example.hospitalbackend.service;

import com.example.hospitalbackend.entity.Department;
import com.example.hospitalbackend.entity.Department;
import com.example.hospitalbackend.entity.ShiftSchedule;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

public interface DepartmentService {
    List<Department> getDepartments();

    Department getByName(String depName);
}
