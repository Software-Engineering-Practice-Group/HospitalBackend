package com.example.hospitalbackend.daoimpl;

import com.example.hospitalbackend.dao.ShiftScheduleDao;
import com.example.hospitalbackend.entity.ShiftSchedule;
import com.example.hospitalbackend.repository.ShiftScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;


@Repository
public class ShiftScheduleDaoImpl implements ShiftScheduleDao {

    @Autowired
    private ShiftScheduleRepository shiftScheduleRepository;

    @Override
    public List<ShiftSchedule>  getShiftSchedulesByDate(Date date){
        return shiftScheduleRepository.getShiftSchedulesByDate(date);
    }
    @Override
    public List<ShiftSchedule> getShiftSchedules(){
        return shiftScheduleRepository.getShiftSchedule();
    }
}
