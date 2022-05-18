package com.example.hospitalbackend.daoimpl;

import com.example.hospitalbackend.dao.DoctorDao;
import com.example.hospitalbackend.entity.Doctor;
import com.example.hospitalbackend.repository.DoctorRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DoctorDaoImpl implements DoctorDao {
    @Autowired
    private DoctorRespository doctorRespository;

    @Override
    public Doctor getDoctorById(Integer id){
        return doctorRespository.getById(id);
    }

    @Override
    public List<Doctor> getDoctors(){
        return doctorRespository.getDoctors();
    }
}
