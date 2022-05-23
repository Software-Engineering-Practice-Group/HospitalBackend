package com.example.hospitalbackend.serviceimpl;

import com.example.hospitalbackend.dao.DepartmentDao;
import com.example.hospitalbackend.entity.Department;
import com.example.hospitalbackend.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public List<Department> getDepartments(){
        return departmentDao.getDepartments();
    }

    @Override
    public Department getByName(String depName){
        return departmentDao.getByName(depName);
    }

}
