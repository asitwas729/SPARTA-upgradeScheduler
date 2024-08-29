package com.sparta.upgradescheduler.dto.schedule;

import com.sparta.upgradescheduler.entity.Schedule;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ScheduleRequestDto {
    private Long scheduleId;
    private String username;
    private String title;
    private String content;

    @Builder
    public ScheduleRequestDto(String username, String title, String content){
        this.username = username;
        this.title = title;
        this.content = content;
    }

    public Schedule ToEntity(){
        return Schedule.builder()
            .username(this.username)
            .title(this.title)
            .content(this.content)
            .build();
    }
}
