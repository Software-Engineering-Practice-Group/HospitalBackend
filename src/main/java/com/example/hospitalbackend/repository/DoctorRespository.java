package com.example.hospitalbackend.repository;

import com.example.hospitalbackend.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoctorRespository extends JpaRepository<Doctor,Integer> {

//        List<Doctor> findDoctorByDepartment(String department);

        @Override
        @Query("from Doctor where id=:id")
        Doctor getById(Integer id);

        @Query("select b from Doctor b")
        List<Doctor> getDoctors();


}
