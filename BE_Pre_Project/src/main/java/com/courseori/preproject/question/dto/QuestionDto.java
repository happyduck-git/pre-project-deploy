package com.courseori.preproject.question.dto;

import com.courseori.preproject.answer.entity.Answer;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

public class QuestionDto {

    public static class Post {

        private Long userId;
        private String title;
        private String body;
        private List<String> tagList;

    }

    public static class Patch {

        private Long userId;
        private Long questionId;
        private String title;
        private String body;
        private List<String> tagList;

    }

    @AllArgsConstructor
    @Getter
    public static class Response {

        private Long questionId;
        private Long userId;
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
