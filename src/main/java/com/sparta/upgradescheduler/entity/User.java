package com.sparta.upgradescheduler.entity;

import com.sparta.upgradescheduler.dto.schedule.ScheduleCreateRequestDto;
import com.sparta.upgradescheduler.dto.user.UserRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "User")
@Getter
@NoArgsConstructor
public class User extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId;

    @Column(length = 50)
    private String username;

    @Column(length = 200)
    private String email;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<UserAndSchedule> userAndSchedule = new ArrayList<>();

    public User(UserRequestDto dto){
        this.email = dto.getEmail();
        this.username = dto.getUsername();
    }
}
