package com.courseori.preproject.answer.entity;

import com.courseori.preproject.question.entity.Question;
import com.courseori.preproject.user.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long answerId;

    @ManyToOne(targetEntity = Question.class)
    @JoinColumn(name = "QUESTION_ID")
    private List<Question> question;

    private String body;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private Users users;

    int votes;



    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private Users users;

    private String body;

    int votes;
}
