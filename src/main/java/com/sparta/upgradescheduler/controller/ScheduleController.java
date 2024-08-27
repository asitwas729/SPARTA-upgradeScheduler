package com.sparta.upgradescheduler.controller;

import com.sparta.upgradescheduler.dto.schedule.ScheduleCreateRequestDto;
import com.sparta.upgradescheduler.dto.schedule.ScheduleCreateResponseDto;
import com.sparta.upgradescheduler.service.ScheduleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping("/save")
    public ScheduleCreateResponseDto createSchedule(@RequestBody ScheduleCreateRequestDto dto){
        return scheduleService.createSchedule(dto);
    }
}
