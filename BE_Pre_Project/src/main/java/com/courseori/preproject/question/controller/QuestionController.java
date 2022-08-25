package com.courseori.preproject.question.controller;

import com.courseori.preproject.question.dto.QuestionDto;
import com.courseori.preproject.question.entity.Question;
import com.courseori.preproject.question.mapper.QuestionMapper;
import com.courseori.preproject.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/questions")
public class QuestionController {



    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionMapper mapper;

    @PostMapping
    public ResponseEntity postQuestion(@RequestBody QuestionDto.Post requestBody){

        Question question = mapper.questionPostDtoToQuestion(requestBody);


        Question postQuestion = questionService.createQuestion(question);

        QuestionDto.Response response = mapper.questionToQuestionResponseDto(postQuestion);


        System.out.println("post 완료");

        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PatchMapping("/{question-id}")
    public ResponseEntity patchQuestion(@PathVariable("question-id") @Positive long questionId,
                                         @RequestBody QuestionDto.Patch requestBody){
        requestBody.setQuestionId(questionId);

        Question question = questionService.updateQuestion(mapper.questionPatchDtoTOQuestion(requestBody));

        System.out.println("question = " + question);

        System.out.println("업데이트 완료");

        return new ResponseEntity<>(mapper.questionToQuestionResponseDto(question),HttpStatus.ACCEPTED);
    }
}
