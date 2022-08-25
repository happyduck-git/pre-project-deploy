package com.courseori.preproject.question.controller;

import com.courseori.preproject.question.dto.QuestionDto;
import com.courseori.preproject.question.entity.Question;
import com.courseori.preproject.question.mapper.QuestionMapper;

import org.springframework.web.bind.annotation.RequestBody;

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
    
     @PostMapping
    public ResponseEntity postQuestion(@RequestBody QuestionDto.Post requestBody){

        Question question = mapper.questionPostDtoToQuestion(requestBody);


        Question postQuestion = questionService.createQuestion(question);

        QuestionDto.Response response = mapper.questionToQuestionResponseDto(postQuestion);


        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PatchMapping("/{question-id}")
    public ResponseEntity patchQuestion(@PathVariable("question-id") @Positive long questionId,
                                         @RequestBody QuestionDto.Patch requestBody){
        requestBody.setQuestionId(questionId);

        Question question = questionService.updateQuestion(mapper.questionPatchDtoTOQuestion(requestBody));


        return new ResponseEntity<>(mapper.questionToQuestionResponseDto(question),HttpStatus.ACCEPTED);
    }


}
