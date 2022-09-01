package com.courseori.preproject.question.service;

import com.courseori.preproject.question.entity.Question;
import com.courseori.preproject.question.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class QuestionService {

    private QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    public Question findQuestion(long questionId) {


        return questionRepository.findById(questionId).orElseThrow(); //이후 null 처리 필요
    }

    public Page<Question> findQuestions(int page, int size) {
        return questionRepository.findAll(PageRequest.of(page, size, Sort.by("questionId").descending()));
    }
    
     public Question createQuestion(Question question){

        Question postQuestion = questionRepository.save(question);

        return postQuestion;
    }

    public void deleteQuestion(long questionId){
        Question findQuestion = questionRepository.findById(questionId).orElseThrow();
        questionRepository.delete(findQuestion);
    }


    public Question updateQuestion(Question question){

        Question patchQuestion = findVerifiedQuestion(question.getQuestionId());

        Optional.ofNullable(question.getUsers())
                .ifPresent(users -> patchQuestion.setUsers(users)); //ofNullable 필요?
        Optional.ofNullable(question.getTitle())
                .ifPresent(title -> patchQuestion.setTitle(title));
        Optional.ofNullable(question.getBody())
                .ifPresent(body -> patchQuestion.setBody(body));
        Optional.ofNullable(question.getTagList())
                .ifPresent(tags -> patchQuestion.setTagList(tags));

        //수정된 시간 반영
        patchQuestion.setModifiedAt(LocalDateTime.now());

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





