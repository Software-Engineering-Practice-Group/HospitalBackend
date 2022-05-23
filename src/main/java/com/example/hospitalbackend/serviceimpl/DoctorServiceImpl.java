package com.example.hospitalbackend.serviceimpl;

import com.example.hospitalbackend.dao.DoctorDao;
import com.example.hospitalbackend.entity.Doctor;
import com.example.hospitalbackend.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorDao doctorDao;

    @Override
    public Doctor getDoctorById(Integer id){
        return doctorDao.getDoctorById(id);
    }

    @Override
    public String getNameById(Integer userId){
        Doctor tmp = doctorDao.getDoctorById(userId);
        return tmp.getName();
    }

    @Override
    public String getDepById(Integer userId){
        Doctor tmp = doctorDao.getDoctorById(userId);
        return tmp.getDepartment();
    }

    @Override
    public List<Doctor> getDoctors(){
        return doctorDao.getDoctors();
    }
}
