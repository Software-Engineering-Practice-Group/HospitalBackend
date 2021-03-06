package com.example.hospitalbackend.dao;

import com.example.hospitalbackend.entity.ShiftSchedule;

import java.util.Date;
import java.util.List;

public interface ShiftScheduleDao {
    //ShiftSchedule getShiftScheduleByID(Integer id);
    List<ShiftSchedule> getShiftSchedulesByDate(Date date);

    ShiftSchedule getByDocIdAndDate(Integer doctor_id, Date date);

    List<ShiftSchedule> getShiftSchedules();
}
