package com.sparta.upgradescheduler.service;

import com.sparta.upgradescheduler.dto.user.UserRequestDto;
import com.sparta.upgradescheduler.dto.user.UserResponseDto;
import com.sparta.upgradescheduler.entity.User;
import com.sparta.upgradescheduler.repository.UserRespository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRespository userRespository;

    public UserService(UserRespository userRespository) {
        this.userRespository = userRespository;
    }

    public UserResponseDto createUser(UserRequestDto dto){
        User user = new User(dto);
        User saveUser = userRespository.save(user);
        return new UserResponseDto(
            saveUser.getUserId(),
            "created",
            201
        );
    }
}
