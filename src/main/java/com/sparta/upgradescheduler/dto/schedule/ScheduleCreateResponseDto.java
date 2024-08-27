package com.sparta.upgradescheduler.dto.schedule;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleCreateResponseDto {
    private Long scheduleId;
    private String message;
    private Integer statusCode;

}
