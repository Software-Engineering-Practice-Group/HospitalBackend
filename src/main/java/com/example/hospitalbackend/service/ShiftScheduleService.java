package com.example.hospitalbackend.service;

import com.example.hospitalbackend.entity.ShiftSchedule;

import java.util.Date;
import java.util.List;

public interface ShiftScheduleService {
    List<ShiftSchedule> getShiftSchedulesByDate(Date date);

    ShiftSchedule getByDocIdAndDate(Integer doctor_id, Date date);

    List<ShiftSchedule> getShiftSchedules();
}
