package com.example.hospitalbackend.daoimpl;

import com.example.hospitalbackend.dao.DepartmentDao;
import com.example.hospitalbackend.entity.Department;
import com.example.hospitalbackend.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public List<Department> getDepartments(){
        return departmentRepository.getDepartments();
    }
}