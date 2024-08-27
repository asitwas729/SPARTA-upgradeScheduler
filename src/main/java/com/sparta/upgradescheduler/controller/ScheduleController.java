package com.sparta.upgradescheduler.controller;

import com.sparta.upgradescheduler.dto.schedule.ScheduleCreateRequestDto;
import com.sparta.upgradescheduler.dto.schedule.ScheduleCreateResponseDto;
import com.sparta.upgradescheduler.dto.schedule.ScheduleDto;
import com.sparta.upgradescheduler.entity.Schedule;
import com.sparta.upgradescheduler.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ScheduleController {
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    // 저장
    @PostMapping("/schedule/save")
    public ScheduleCreateResponseDto createSchedule(@RequestBody ScheduleCreateRequestDto dto){
        return scheduleService.createSchedule(dto);
    }
    
    // 단건 조회
    @GetMapping("/schedule/{scheduleId}")
    public Schedule getSchedule(@PathVariable("scheduleId") Long scheduleId){
        return scheduleService.getSchedule(scheduleId);
    }
    
    
    // 수정
    @PutMapping("/schedule/{scheduleId}")
    public Long updateSchedule(@PathVariable("scheduleId") Long scheduleId, @RequestBody ScheduleDto dto){
        return scheduleService.updateSchedule(scheduleId, dto);
    }
}
