package com.sparta.upgradescheduler.entity;

import com.sparta.upgradescheduler.dto.ScheduleRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Schedule")
@Getter
public class Schedule extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long scheduleId;
    private String username;
    private String title;
    private String content;

    @OneToMany(mappedBy = "schedule")
    private List<Comment> commentList = new ArrayList<>();

    public Schedule(ScheduleRequestDto dto){
        this.username = dto.getUsername();
        this.title = dto.getTitle();
        this.content = dto.getContent();
    }

    public Schedule() {

    }
}
