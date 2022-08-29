package com.courseori.preproject.question.mapper;

import com.courseori.preproject.question.dto.QuestionDto;
import com.courseori.preproject.question.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;


@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface QuestionMapper {

    Question questionPostDtoToQuestion(QuestionDto.Post post);
    Question questionPatchDtoTOQuestion(QuestionDto.Patch patch);
       
    QuestionDto.Response questionToQuestionResponse(Question question);

    List<QuestionDto.Response> questionsToQuestionResponses(List<Question> questionList);

}
