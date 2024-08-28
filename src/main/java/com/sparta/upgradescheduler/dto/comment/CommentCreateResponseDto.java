package com.sparta.upgradescheduler.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentCreateResponseDto {
    private Long commentId;
    private String message;
    private Integer statusCode;
}
