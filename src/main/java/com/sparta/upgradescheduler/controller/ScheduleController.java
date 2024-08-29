package com.sparta.upgradescheduler.controller;

import com.sparta.upgradescheduler.dto.schedule.ScheduleCreateRequestDto;
import com.sparta.upgradescheduler.dto.schedule.ScheduleCreateResponseDto;
import com.sparta.upgradescheduler.dto.schedule.ScheduleDto;
import com.sparta.upgradescheduler.dto.schedule.ScheduleResponseDto;
import com.sparta.upgradescheduler.entity.Schedule;
import com.sparta.upgradescheduler.service.ScheduleService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // 모든 일정 조회 페이지네이션
    @GetMapping("/schedule")
    public List<ScheduleResponseDto> getScheduleList(){
        return scheduleService.getScheduleList();
    }
    
    
    // 수정
    @PutMapping("/schedule/{scheduleId}")
    public Long updateSchedule(@PathVariable("scheduleId") Long scheduleId, @RequestBody ScheduleDto dto){
        return scheduleService.updateSchedule(scheduleId, dto);
    }

    @DeleteMapping("/schedule/{scheduleId}")
    public Long deleteSchedule(@PathVariable("scheduleId") Long scheduleId){
        return scheduleService.deleteSchedule(scheduleId);
    }
}
