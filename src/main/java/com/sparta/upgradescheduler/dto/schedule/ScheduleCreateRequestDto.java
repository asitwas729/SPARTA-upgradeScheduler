package com.sparta.upgradescheduler.dto.schedule;

import lombok.Getter;

@Getter
public class ScheduleCreateRequestDto {
    private String username;
    private String title;
    private String content;
}
