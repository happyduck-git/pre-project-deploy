package com.courseori.preproject.users.controller;

import com.courseori.preproject.users.dto.UserDto;
import com.courseori.preproject.users.entity.Users;
import com.courseori.preproject.users.mapper.UsersMapper;
import com.courseori.preproject.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private UsersMapper mapper;

    public UsersController(UsersService usersService, UsersMapper mapper) {
        this.usersService = usersService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postUser(@RequestBody UserDto.Post responseBody){

        Users users = mapper.usersPostDtoToUser(responseBody);

        Users postUser = usersService.createUser(users);

        UserDto.Response response = mapper.userToUserResponse(postUser);

        return new ResponseEntity(response, HttpStatus.CREATED);

    }
}
