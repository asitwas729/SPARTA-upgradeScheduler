package com.sparta.upgradescheduler.dto.schedule;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ScheduleResponseDto {
    private Long scheduleId;
    private String username;
    private String title;
    private String content;

    @Builder
    public ScheduleResponseDto(String username, String title, String content){
        this.username = username;
        this.title = title;
        this.content = content;
    }
}
