package com.sparta.upgradescheduler.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CommentListResponseDto {
    private String message;
    private Integer statusCode;
    private List<CommentDto> memberDtoList;
}
