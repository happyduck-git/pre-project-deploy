package com.courseori.preproject.question.dto;

import com.courseori.preproject.answer.entity.Answer;
import com.courseori.preproject.users.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

public class QuestionDto {


    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Post {

        @NotBlank
        private long userId;
        @NotBlank
        private String title;
        @NotBlank
        private String body;
        private List<String> tagList;
        private List<Answer> answerList;


        public Users getUsers() {
            Users user = new Users();
            user.setUserId(userId);
            return user;
        }


    }

    @Getter
    @Setter
    @AllArgsConstructor
//    @NoArgsConstructor
    public static class Patch {

        private long userId;
        @NotBlank
        private long questionId;
        @Nullable
        private String title;
        @Nullable
        private String body;
        @Nullable
        private List<String> tagList;

    }



    @AllArgsConstructor
    @Setter
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

        public void setUsers(Users user) {
            this.userId = user.getUserId();
        }


        @Override
        public String toString() {
            return "Response{" +
                    "questionId=" + questionId +
                    ", userId=" + userId +
                    ", title='" + title + '\'' +
                    ", body='" + body + '\'' +
                    '}';
        }
    }

}
