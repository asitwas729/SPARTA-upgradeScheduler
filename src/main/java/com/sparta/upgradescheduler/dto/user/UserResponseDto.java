package com.sparta.upgradescheduler.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserResponseDto {
    private Long userId;
    private String message;
    private Integer statusCode;
}
