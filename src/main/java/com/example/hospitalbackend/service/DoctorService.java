package com.example.hospitalbackend.service;

import com.example.hospitalbackend.entity.Doctor;

import java.util.List;

public interface DoctorService {

    Doctor getDoctorById(Integer id);

    String getNameById(Integer userId);

    String getDepById(Integer userId);

    List<Doctor> getDoctors();
}
