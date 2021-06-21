package com.example.restservice.controller;

import com.example.restservice.model.dto.UserDto;
import com.example.restservice.model.request.LoginRequest;
import com.example.restservice.model.response.BaseResponse;
import com.example.restservice.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@RestController
@RequestMapping(path = "/user")
@Api(tags = "User Information")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Show Users")
    @GetMapping(path = "/all-user")
    public ResponseEntity<List<UserDto>> getAllUser(){
     return new ResponseEntity(userService.getAllUsers(), HttpStatus.OK);
    }

    @ApiOperation(value ="Save User")
    @PostMapping(path = "/save-user")
    public  ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        return new ResponseEntity(userService.createUser(userDto),HttpStatus.OK);
    }

    @ApiOperation(value = "Get User By Id")
    @GetMapping(path = "/{userId}")
    public ResponseEntity<UserDto> getUserByUserId(@PathVariable(name = "userId") Long userId){
        return new ResponseEntity(userService.getUserByUserId(userId),HttpStatus.OK);
    }

    @ApiOperation(value = "Delete User")
    @PostMapping(path = "/delete")
    public ResponseEntity<BaseResponse> deleteUser(@RequestParam(name = "userId") Long userId){
        return new ResponseEntity(userService.deleteUserById(userId),HttpStatus.OK);
    }

    @ApiOperation(value = "Login")
    @PostMapping(path = "/login")
    public ResponseEntity<BaseResponse> loginUser(@RequestBody LoginRequest loginRequest){
        return new ResponseEntity(userService.loginUser(loginRequest),HttpStatus.OK);
    }




}
