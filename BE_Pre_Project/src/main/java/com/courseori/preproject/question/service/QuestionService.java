package com.courseori.preproject.question.service;

import com.courseori.preproject.question.entity.Question;
import com.courseori.preproject.question.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class QuestionService {


    @Autowired
    QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question createQuestion(Question question){

        Question postQuestion = questionRepository.save(question);

        return postQuestion;
    }

    public Question updateQuestion(Question question){
        Question patchQuestion = findVerifiedQuestion(question.getQuestionId());

        Optional.ofNullable(patchQuestion.getUsers())
                .ifPresent(users -> patchQuestion.setUsers(users));
        Optional.ofNullable(patchQuestion.getTitle())
                .ifPresent(title -> question.setTitle(title));
        Optional.ofNullable(patchQuestion.getBody())
                .ifPresent(body -> question.setBody(body));

        return questionRepository.save(patchQuestion);
    }



    //Question 이 있는지 없다면 예외
    public Question findVerifiedQuestion(long questionId){
        Optional<Question> optionalQuestion =
                questionRepository.findById(questionId);
        Question findQuestion =
                optionalQuestion.orElseThrow(() -> new NoSuchElementException());

        return findQuestion;
    }
}
