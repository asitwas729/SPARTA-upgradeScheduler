package com.sparta.upgradescheduler.entity;

import com.sparta.upgradescheduler.dto.schedule.ScheduleCreateRequestDto;
import com.sparta.upgradescheduler.dto.schedule.ScheduleDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Schedule")
@Getter
public class Schedule extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "schedule_id")
    private Long scheduleId;

    @Column(nullable = false, length = 20)
    private String username;

    @Column(nullable = false, length = 20)
    private String title;

    @Column(length = 200)
    private String content;

    @OneToMany(mappedBy = "schedule", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    // 삭제 여부
    @Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean isDeleted = false;

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL)
    private List<UserAndSchedule> userAndSchedule = new ArrayList<>();

    public Schedule(ScheduleCreateRequestDto dto){
        this.username = dto.getUsername();
        this.title = dto.getTitle();
        this.content = dto.getContent();
    }

    public Schedule() {

    }

    public void update(ScheduleDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }

    @Builder
    public Schedule(String username, String title, String content){
        this.username = username;
        this.title = title;
        this.content = content;
    }
}
