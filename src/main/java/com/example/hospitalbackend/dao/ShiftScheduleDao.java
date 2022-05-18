package com.example.hospitalbackend.dao;

import com.example.hospitalbackend.entity.ShiftSchedule;

import java.sql.Date;
import java.util.List;

public interface ShiftScheduleDao {
    //ShiftSchedule getShiftScheduleByID(Integer id);
    List<ShiftSchedule> getShiftSchedulesByDate(Date date);

    List<ShiftSchedule> getShiftSchedules();
}
