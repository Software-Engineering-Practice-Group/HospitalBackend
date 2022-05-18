package com.example.hospitalbackend.service;

import com.example.hospitalbackend.entity.ShiftSchedule;

import java.sql.Date;
import java.util.List;

public interface ShiftScheduleService {
    List<ShiftSchedule> getShiftSchedulesByDate(Date date);

    List<ShiftSchedule> getShiftSchedules();
}
