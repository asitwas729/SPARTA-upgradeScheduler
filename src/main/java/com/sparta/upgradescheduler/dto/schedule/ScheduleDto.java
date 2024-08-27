package com.sparta.upgradescheduler.dto.schedule;

import com.sparta.upgradescheduler.entity.Comment;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class ScheduleDto {
    private Long scheduleId;

    private String username;

    private String title;

    private String content;

    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

}
