package com.sparta.upgradescheduler.controller;

import com.sparta.upgradescheduler.dto.user.UserRequestDto;
import com.sparta.upgradescheduler.dto.user.UserResponseDto;
import com.sparta.upgradescheduler.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/save")
    public UserResponseDto createUser(@RequestBody UserRequestDto dto){
        return userService.createUser(dto);
    }
}
