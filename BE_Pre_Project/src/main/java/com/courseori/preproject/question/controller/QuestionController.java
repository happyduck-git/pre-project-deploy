package com.courseori.preproject.question.controller;

import com.courseori.preproject.question.dto.QuestionDto;
import com.courseori.preproject.question.entity.Question;
import com.courseori.preproject.question.mapper.QuestionMapper;
import com.courseori.preproject.question.repository.QuestionRepository;
import com.courseori.preproject.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    private QuestionService questionService;

    private QuestionMapper questionMapper;

    @Autowired
    public QuestionController(QuestionService questionService, QuestionMapper questionMapper) {
        this.questionService = questionService;
        this.questionMapper = questionMapper;
    }

    @GetMapping("/{question-id}")
    public ResponseEntity getQuestion(@PathVariable("question-id") @Positive long questionId){



        Question question = questionService.findQuestion(questionId);
        QuestionDto.Response response = questionMapper.questionToQuestionResponse(question);

        System.out.println("questionId = " + questionId);


        return  new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity getQuestions(@Positive @RequestParam int page,
                                       @Positive @RequestParam int size) {

        Page<Question> questionPage = questionService.findQuestions(page - 1, size);
        List<Question> questions = questionPage.getContent();

        List<QuestionDto.Response> responses = questionMapper.questionsToQuestionResponses(questions);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @DeleteMapping("/{question-id}")
    public ResponseEntity deleteQuestion(
            @PathVariable("question-id") @Positive long questionId){
        questionService.deleteQuestion(questionId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
