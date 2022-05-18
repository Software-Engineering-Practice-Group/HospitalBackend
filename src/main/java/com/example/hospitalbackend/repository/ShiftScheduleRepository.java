package com.example.hospitalbackend.repository;

import com.example.hospitalbackend.entity.ShiftSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface ShiftScheduleRepository  extends JpaRepository<ShiftSchedule,Integer> {

    @Query("from ShiftSchedule where date=:date")
    List<ShiftSchedule> getShiftSchedulesByDate(Date date);

    @Query("select b from ShiftSchedule b")
    List<ShiftSchedule> getShiftSchedule();
}
