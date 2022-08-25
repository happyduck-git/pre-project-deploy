package com.courseori.preproject.question.service;

import com.courseori.preproject.question.entity.Question;
import com.courseori.preproject.question.repository.QuestionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    private QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question findQuestion(long questionId) {


        return questionRepository.findById(questionId).orElseThrow(); //이후 null 처리 필요
    }

    public Page<Question> findQuestions(int page, int size) {
        return questionRepository.findAll(PageRequest.of(page, size, Sort.by("questionId").descending()));
    }

    public Question createQuestion(Question question) {
        //logic ( 필요시)
        return questionRepository.save(question);
    }

    public Question updateQuestion(Question question) {
        //logic
        return questionRepository.save(question);
    }

    public void deleteQuestion(long questionId){
        Question findQuestion = questionRepository.findById(questionId).orElseThrow();
        questionRepository.delete(findQuestion);
    }

}



























