package com.example.hospitalbackend.repository;

import com.example.hospitalbackend.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {

        @Query("select b from Department b")
        List<Department> getDepartments();

}
