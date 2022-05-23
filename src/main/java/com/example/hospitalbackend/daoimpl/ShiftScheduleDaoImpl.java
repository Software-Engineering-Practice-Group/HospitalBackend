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
    public List<ShiftSchedule>  getShiftSchedulesByDate(Date date){
        //【util.Date转sql.Date后才能正常操作数据库】
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        //添加（debug用
//        ShiftSchedule newSche= new ShiftSchedule(sqlDate,1,"张锋",2,2,2,2);
//        System.out.println(newSche);
//        shiftScheduleRepository.save(newSche);
//        shiftScheduleRepository.flush();
        //读取
        List<ShiftSchedule> scheGot=shiftScheduleRepository.getShiftSchedulesByDate(sqlDate);
        System.out.println(scheGot);
        return scheGot;
    }
    @Override
    public List<ShiftSchedule> getShiftSchedules(){
        return shiftScheduleRepository.getShiftSchedule();
    }
}
