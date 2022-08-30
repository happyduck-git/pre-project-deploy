package com.courseori.preproject.answer.entity;

import com.courseori.preproject.question.entity.Question;
import com.courseori.preproject.users.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
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
    private Question question;

    private String body;

    @ElementCollection(targetClass = String.class) //수정해야 할 수도 있습니다.
    private List<String> commentList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private Users users;

    int votes;

}
