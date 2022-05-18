package com.example.hospitalbackend.dao;

import com.example.hospitalbackend.entity.Doctor;

import java.util.List;

public interface DoctorDao {

    Doctor getDoctorById(Integer id);

    List<Doctor> getDoctors();
}
