package com.courseori.preproject.answer.entity;

import com.courseori.preproject.question.entity.Question;
import com.courseori.preproject.user.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.stream.events.Comment;
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

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    private String body;

    private Users users;

    List<Comment> commentList;

    int votes;


}
