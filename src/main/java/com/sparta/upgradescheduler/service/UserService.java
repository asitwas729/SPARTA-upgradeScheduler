package com.sparta.upgradescheduler.service;

import com.sparta.upgradescheduler.dto.comment.CommentDto;
import com.sparta.upgradescheduler.dto.user.UserDto;
import com.sparta.upgradescheduler.dto.user.UserListResonseDto;
import com.sparta.upgradescheduler.dto.user.UserRequestDto;
import com.sparta.upgradescheduler.dto.user.UserResponseDto;
import com.sparta.upgradescheduler.entity.User;
import com.sparta.upgradescheduler.repository.UserRespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRespository userRespository;

    public UserService(UserRespository userRespository) {
        this.userRespository = userRespository;
    }

    // 유저 저장
    public UserResponseDto createUser(UserRequestDto dto){
        User user = new User(dto);
        User saveUser = userRespository.save(user);
        return new UserResponseDto(
            saveUser.getUserId(),
            "created",
            201
        );
    }
    
    // 단건 조회
    public User getUser(Long id){
        return userRespository.findById(id).orElseThrow(() ->
            new IllegalArgumentException("선택한 유저는 존재하지않습니다.")
        );
    }
    
    
    // 전체 조회
    public UserListResonseDto getUserList(){
        List<User> userList = userRespository.findAll();
        List<UserDto> userDtoList = userList.stream().map(user -> new UserDto(
            user.getUserId(),
            user.getEmail()
        )).toList();

        return new UserListResonseDto(
            "success",
            200,
            userDtoList
        );
    }
    
    
    // 삭제
    
    
    
    
}
