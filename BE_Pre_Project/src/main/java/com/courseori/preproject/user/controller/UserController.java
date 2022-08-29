package com.courseori.preproject.user.controller;

import com.courseori.preproject.user.dto.UserDto;
import com.courseori.preproject.user.entity.Users;
import com.courseori.preproject.user.mapper.UserMapper;
import com.courseori.preproject.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    private UserMapper mapper;

    public UserController(UserService userService, UserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postUser(@RequestBody UserDto.Post responseBody){

        Users users = mapper.userPostDtoToUser(responseBody);

        Users postUser = userService.createUser(users);

        UserDto.Response response = mapper.userToUserResponse(postUser);

        return new ResponseEntity(response, HttpStatus.CREATED);

    }
}
