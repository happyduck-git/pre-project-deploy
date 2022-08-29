package com.courseori.preproject.users.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

public class UserDto {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Post{
        private String username;
        private String password;
    }

//    @AllArgsConstructor
//    @NoArgsConstructor
//    @Getter
//    @Setter
//    public static class Patch{
//
//    }

    @AllArgsConstructor
    @Getter
    public static class Response{

        private long userId;
        private String username;
        private LocalDateTime joinedAt;


    }
}
