package com.courseori.preproject.answer.entity;

import com.courseori.preproject.question.entity.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;


}
