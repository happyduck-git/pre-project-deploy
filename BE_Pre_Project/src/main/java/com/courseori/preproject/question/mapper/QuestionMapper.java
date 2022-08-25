package com.courseori.preproject.question.mapper;

import com.courseori.preproject.question.dto.QuestionDto;
import com.courseori.preproject.question.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface QuestionMapper {

    Question questionPostDtoToQuestion(QuestionDto.Post post);
    Question questionPatchDtoTOQuestion(QuestionDto.Patch patch);
    QuestionDto.Response questionToQuestionResponseDto(Question question);
//    List<QuestionDto.Response> questionsToQuestionResponseDtos(List<Question> question);
}
