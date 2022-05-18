package com.example.hospitalbackend.controller;

import com.example.hospitalbackend.service.ShiftScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduleController {

    @Autowired
    private ShiftScheduleService shiftScheduleService;
}
