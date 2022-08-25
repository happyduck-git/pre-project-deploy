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
    private List<String> tagList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private Users users;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime modifiedAt = LocalDateTime.now();
    private int views;
    private int votes;

    @OneToMany(mappedBy = "question")
    private List<Answer> answerList = new ArrayList<>();

    public Question(String title, String body, Users users, int views, int votes) {
        this.title = title;
        this.body = body;
        this.users = users;
        this.views = views;
        this.votes = votes;
    }
}
