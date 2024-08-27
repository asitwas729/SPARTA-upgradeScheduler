package com.sparta.upgradescheduler.dto;

import com.sparta.upgradescheduler.entity.Comment;
import com.sparta.upgradescheduler.entity.Schedule;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ScheduleResponseDto {
    private Long scheduleId;
    private String username;
    private String title;
    private String content;
    @CreatedDate
    private LocalDateTime createAt;
    @LastModifiedDate
    private LocalDateTime updateAt;

    @OneToMany(mappedBy = "schedule")
    private List<Comment> commentList = new ArrayList<>();


    public ScheduleResponseDto(Schedule schedule) {
        this.scheduleId = schedule.getScheduleId();
        this.username = schedule.getUsername();
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
        this.commentList = schedule.getComments();
    }
}
