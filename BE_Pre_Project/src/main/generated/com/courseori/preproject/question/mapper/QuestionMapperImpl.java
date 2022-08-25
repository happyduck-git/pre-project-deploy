package com.courseori.preproject.question.mapper;

import com.courseori.preproject.answer.entity.Answer;
import com.courseori.preproject.question.dto.QuestionDto;
import com.courseori.preproject.question.entity.Question;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-25T16:56:17+0900",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.15 (Azul Systems, Inc.)"
)
@Component
public class QuestionMapperImpl implements QuestionMapper {

    @Override
    public Question questionPostDtoToQuestion(QuestionDto.Post post) {
        if ( post == null ) {
            return null;
        }

        Question question = new Question();

        question.setTitle( post.getTitle() );
        question.setBody( post.getBody() );
        List<String> list = post.getTagList();
        if ( list != null ) {
            question.setTagList( new ArrayList<String>( list ) );
        }

        return question;
    }

    @Override
    public Question questionPatchDtoTOQuestion(QuestionDto.Patch patch) {
        if ( patch == null ) {
            return null;
        }

        Question question = new Question();

        question.setQuestionId( patch.getQuestionId() );
        question.setTitle( patch.getTitle() );
        question.setBody( patch.getBody() );
        List<String> list = patch.getTagList();
        if ( list != null ) {
            question.setTagList( new ArrayList<String>( list ) );
        }

        return question;
    }

    @Override
    public QuestionDto.Response questionToQuestionResponseDto(Question question) {
        if ( question == null ) {
            return null;
        }

        List<String> tagList = null;
        long questionId = 0L;
        String title = null;
        String body = null;
        LocalDateTime createdAt = null;
        LocalDateTime modifiedAt = null;
        int views = 0;
        int votes = 0;

        List<String> list = question.getTagList();
        if ( list != null ) {
            tagList = new ArrayList<String>( list );
        }
        questionId = question.getQuestionId();
        title = question.getTitle();
        body = question.getBody();
        createdAt = question.getCreatedAt();
        modifiedAt = question.getModifiedAt();
        views = question.getViews();
        votes = question.getVotes();

        long userId = 0L;
        List<Answer> answerList = null;

        QuestionDto.Response response = new QuestionDto.Response( userId, questionId, title, body, tagList, createdAt, modifiedAt, views, votes, answerList );

        return response;
    }
}
