package com.sparta.upgradescheduler.dto.comment;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentCreateRequestDto {
    private String comment;
    private String username;
    private Long scheduleId;
}
