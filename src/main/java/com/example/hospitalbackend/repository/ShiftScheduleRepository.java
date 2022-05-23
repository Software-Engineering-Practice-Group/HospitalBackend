package com.example.hospitalbackend.repository;

import com.example.hospitalbackend.entity.ShiftSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//import java.util.Date;
import java.util.List;

public interface ShiftScheduleRepository  extends JpaRepository<ShiftSchedule,Integer> {

    @Query(value = "from ShiftSchedule where date between ?1 and ?1")
    List<ShiftSchedule> getShiftSchedulesByDate(java.sql.Date date);

    @Query("select b from ShiftSchedule b")
    List<ShiftSchedule> getShiftSchedule();

}
