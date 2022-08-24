package com.courseori.preproject.question.entity;

import com.courseori.preproject.answer.entity.Answer;
import com.courseori.preproject.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Question {

    @Id
    private Long questionId;
    private String title;
    private String body;
    private List<String> tags;
    @ManyToOne()
    private User user;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private int views;
    private int votes;
    private List<Answer> answers;



}
