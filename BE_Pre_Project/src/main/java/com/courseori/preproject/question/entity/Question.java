package com.courseori.preproject.question.entity;

import com.courseori.preproject.answer.entity.Answer;
import com.courseori.preproject.users.entity.Users;
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
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long questionId;

    private String title;
    private String body;

    @ElementCollection(targetClass = String.class) //수정해야 할 수도 있습니다.
    private List<String> tagList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private Users users;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime modifiedAt = LocalDateTime.now();
    private int views = 0;
    private int votes = 0;

    @OneToMany(mappedBy = "question")
    private List<Answer> answerList = new ArrayList<>();

    public Question(String title, String body, Users users, int views, int votes) {
        this.title = title;
        this.body = body;
        this.users = users;
        this.views = views;
        this.votes = votes;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
