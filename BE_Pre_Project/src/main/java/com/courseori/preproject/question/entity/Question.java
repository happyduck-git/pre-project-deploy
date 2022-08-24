package com.courseori.preproject.question.entity;

import com.courseori.preproject.answer.entity.Answer;
import com.courseori.preproject.user.entity.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;
    private String title;
    private String body;

    @ElementCollection(targetClass = String.class) //수정해야 할 수도 있습니다.
    private List<String> tags = new ArrayList<>();

    private String tag;
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private Users users;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private int views;
    private int votes;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers = new ArrayList<>();



}
