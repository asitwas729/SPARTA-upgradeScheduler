package com.sparta.upgradescheduler.controller;

import com.sparta.upgradescheduler.dto.user.UserRequestDto;
import com.sparta.upgradescheduler.dto.user.UserResponseDto;
import com.sparta.upgradescheduler.entity.User;
import com.sparta.upgradescheduler.service.UserService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Long id){
        return userService.getUser(id);
    }
}
