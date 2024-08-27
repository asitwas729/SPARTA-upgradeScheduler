package com.sparta.upgradescheduler.service;

import com.sparta.upgradescheduler.dto.ScheduleRequestDto;
import com.sparta.upgradescheduler.dto.ScheduleResponseDto;
import com.sparta.upgradescheduler.entity.Schedule;
import com.sparta.upgradescheduler.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public ScheduleResponseDto createSchedule(ScheduleRequestDto dto){
        // requestDto -> entity
        Schedule schedule = new Schedule(dto);

        // DB 저장
        Schedule saveSchedule = scheduleRepository.save(schedule);

        // entity -> responsedto
        return new ScheduleResponseDto(saveSchedule);
    }
}
