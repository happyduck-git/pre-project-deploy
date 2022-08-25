package com.courseori.preproject.question.dto;

import com.courseori.preproject.answer.entity.Answer;
import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.List;

public class QuestionDto {


    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Post {

        private long userId;
        private String title;
        private String body;
        private List<String> tagList;
        private List<Answer> answerList;

    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Patch {

        private long userId;
        private long questionId;
        private String title;
        private String body;
        private List<String> tagList;

    }


    @AllArgsConstructor
    @Getter
    public static class Response {

        private long questionId;
        private long userId;

        private String title;
        private String body;
        private List<String> tagList;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;
        private int views;
        private int votes;
        private List<Answer> answerList;

    }

}
