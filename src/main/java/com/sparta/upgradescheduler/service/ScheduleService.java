package com.sparta.upgradescheduler.service;

import com.sparta.upgradescheduler.dto.schedule.ScheduleCreateRequestDto;
import com.sparta.upgradescheduler.dto.schedule.ScheduleCreateResponseDto;
import com.sparta.upgradescheduler.dto.schedule.ScheduleDto;
import com.sparta.upgradescheduler.entity.Schedule;
import com.sparta.upgradescheduler.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public Schedule getSchedule(Long scheduleId){
        return scheduleRepository.findById(scheduleId).orElseThrow(() ->
            new IllegalArgumentException("선택한 일정은 존재하지 않습니다.")
        );
    }

    @Transactional
    public Long updateSchedule(Long scheduleId, ScheduleDto dto) {
        // 해당 일정 존재하는지 DB 확인
        Schedule schedule = getSchedule(scheduleId);

        // 일정 수정
        schedule.update(dto);

        return scheduleId;
    }

}
