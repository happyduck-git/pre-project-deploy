package com.courseori.preproject.question.mapper;

import com.courseori.preproject.question.dto.QuestionDto;
import com.courseori.preproject.question.entity.Question;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    QuestionDto.Response questionToQuestionResponse(Question question);

    List<QuestionDto.Response> questionsToQuestionResponses(List<Question> questionList);

    Question questionPostDtoToQuestion(QuestionDto.Post post);
    Question questionPatchDtoTOQuestion(QuestionDto.Patch patch);


}
