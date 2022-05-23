package com.example.hospitalbackend.serviceimpl;

import com.example.hospitalbackend.dao.ShiftScheduleDao;
import com.example.hospitalbackend.entity.ShiftSchedule;
import com.example.hospitalbackend.service.ShiftScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ShiftScheduleServiceImpl implements ShiftScheduleService {

    @Autowired
    private ShiftScheduleDao shiftScheduleDao;

    @Override
    public List<ShiftSchedule> getShiftSchedulesByDate(Date date)
    {
       return shiftScheduleDao.getShiftSchedulesByDate(date);
    }

    @Override
    public List<ShiftSchedule> getShiftSchedules(){
        return shiftScheduleDao.getShiftSchedules();
    }
}
