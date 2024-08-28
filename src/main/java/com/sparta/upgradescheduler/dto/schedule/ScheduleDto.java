package com.sparta.upgradescheduler.dto.schedule;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleDto {
    private Long scheduleId;

    private String username;

    private String title;

    private String content;
}
