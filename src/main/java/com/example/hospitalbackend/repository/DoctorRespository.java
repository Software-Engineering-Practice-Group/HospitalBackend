package com.example.hospitalbackend.repository;

import com.example.hospitalbackend.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoctorRespository extends JpaRepository<Doctor,Integer> {

        Doctor getDoctorById(Integer id);
        List<Doctor> findDoctorByDepartment(String department);

        @Query("select b from Doctor b")
        List<Doctor> getDoctors();


}
