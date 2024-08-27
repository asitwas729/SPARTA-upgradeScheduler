package com.sparta.upgradescheduler.service;

import com.sparta.upgradescheduler.dto.schedule.ScheduleCreateRequestDto;
import com.sparta.upgradescheduler.dto.schedule.ScheduleCreateResponseDto;
import com.sparta.upgradescheduler.entity.Schedule;
import com.sparta.upgradescheduler.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public ScheduleCreateResponseDto createSchedule(ScheduleCreateRequestDto dto){
        // 생성: 회원 엔티티
        Schedule schedule = new Schedule(dto);

        // DB 저장 : 회원
        Schedule saveSchedule = scheduleRepository.save(schedule);

        // 반환 응답
        return new ScheduleCreateResponseDto(
            saveSchedule.getScheduleId(),
            "created",
            201
        );
    }
}
