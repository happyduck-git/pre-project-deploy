package com.courseori.preproject.user.entity;

import com.courseori.preproject.answer.entity.Answer;
import com.courseori.preproject.question.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    String username;
    String password;
    LocalDateTime joinAt = LocalDateTime.now();

    List<Question> questionList = new ArrayList<>();

    List<Answer> answerList = new ArrayList<>();
}
