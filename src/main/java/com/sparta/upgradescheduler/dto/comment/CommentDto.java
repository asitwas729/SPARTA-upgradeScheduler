package com.sparta.upgradescheduler.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CommentDto {
    private Long commentId;

    private String comment;

    private String username;

    private String scheduleName;
}