package com.example.restservice.service;

import com.example.restservice.model.dto.UserDto;
import com.example.restservice.model.request.LoginRequest;
import com.example.restservice.model.response.BaseResponse;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto getUserByUserId(Long userId);

    List<UserDto> getAllUsers();

    BaseResponse deleteUserById(Long userId);

    BaseResponse loginUser(LoginRequest loginRequest);
}
