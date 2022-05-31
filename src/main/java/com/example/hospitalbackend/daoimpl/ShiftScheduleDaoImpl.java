package com.example.hospitalbackend.daoimpl;

import com.example.hospitalbackend.dao.ShiftScheduleDao;
import com.example.hospitalbackend.entity.ShiftSchedule;
import com.example.hospitalbackend.repository.ShiftScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public class ShiftScheduleDaoImpl implements ShiftScheduleDao {

    @Autowired
    private ShiftScheduleRepository shiftScheduleRepository;

    @Override
    public List<ShiftSchedule> getShiftSchedulesByDate(Date date) {
        //【util.Date转sql.Date后才能正常操作数据库】
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        //读取
        List<ShiftSchedule> scheGot = shiftScheduleRepository.getShiftSchedulesByDate(sqlDate);
        System.out.println(scheGot);
        return scheGot;
    }

    @Override
    public ShiftSchedule getByDocIdAndDate(Integer doctor_id, Date date) {
        //【util.Date转sql.Date后才能正常操作数据库】
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        //读取
        ShiftSchedule scheGot = shiftScheduleRepository.getByDocIdAndDate(doctor_id, sqlDate);
//        System.out.println(scheGot);
        return scheGot;
    }

    @Override
    public List<ShiftSchedule> getShiftSchedules() {
        return shiftScheduleRepository.getShiftSchedule();
    }
}
