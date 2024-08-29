package com.sparta.upgradescheduler.dto.user;

import com.sparta.upgradescheduler.dto.comment.CommentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class UserListResonseDto {
    private String message;
    private Integer statusCode;
    private List<UserDto> userDtoList;
}
