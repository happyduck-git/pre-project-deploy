package com.courseori.preproject.users.entity;

import com.courseori.preproject.answer.entity.Answer;
import com.courseori.preproject.question.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    private String username;
    private String password;

    private LocalDateTime joinedAt = LocalDateTime.now();

    @OneToMany(mappedBy = "users")
    List<Question> questionList = new ArrayList<>();

    @OneToMany(mappedBy = "users")
    List<Answer> answerList = new ArrayList<>();

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
