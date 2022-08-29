package com.courseori.preproject.helper;

import com.courseori.preproject.answer.entity.Answer;
import com.courseori.preproject.question.dto.QuestionDto;
import com.courseori.preproject.question.entity.Question;
import com.courseori.preproject.users.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class StubData {

    public static Question getSingleResultQuestion() {
        Users users = new Users();
        Question question = new Question("Title1", "Body1", users, 0,0);

        return question;
    }

    public static QuestionDto.Response getSingleResultBody() {
        List<String> tagList = new ArrayList<>();
        List<Answer> answers = new ArrayList<>();

        QuestionDto.Response response = new QuestionDto.Response(1L,1L, "Title1", "Body1", tagList, LocalDateTime.now(), LocalDateTime.now(), 0, 0, answers);
        return response;
    }


    public static Page<Question> getMultiResultQuestion() {

        Users users1 = new Users();
        Question question1 = new Question("Title1", "Body1", users1, 0,0);
        Question question2 = new Question("Title2", "Body2", users1, 0,0);
        Question question3 = new Question("Title3", "Body3", users1, 0,0);
        Question question4 = new Question("Title4", "Body4", users1, 0,0);
        Question question5 = new Question("Title5", "Body5", users1, 0,0);
        Question question6 = new Question("Title6", "Body6", users1, 0,0);
        Question question7 = new Question("Title7", "Body7", users1, 0,0);
        Question question8 = new Question("Title8", "Body8", users1, 0,0);
        Question question9 = new Question("Title9", "Body9", users1, 0,0);
        Question question10 = new Question("Title10", "Body10", users1, 0,0);


        return new PageImpl<>(List.of(question1,question2, question3, question4, question5, question6, question7, question8, question9, question10),
                PageRequest.of(0, 10, Sort.by("questionId").descending()),
                2);
    }

    public static List<QuestionDto.Response> getMultiResponseBody() {


        List<String> tagList = new ArrayList<>();
        List<Answer> answers = new ArrayList<>();

        QuestionDto.Response response1 = new QuestionDto.Response(1L,1L, "Title1", "Body1", tagList, LocalDateTime.now(), LocalDateTime.now(), 0, 0, answers);
        QuestionDto.Response response2 = new QuestionDto.Response(2L,1L, "Title2", "Body2", tagList, LocalDateTime.now(), LocalDateTime.now(), 0, 0, answers);
        QuestionDto.Response response3 = new QuestionDto.Response(3L,1L, "Title3", "Body3", tagList, LocalDateTime.now(), LocalDateTime.now(), 0, 0, answers);
        QuestionDto.Response response4 = new QuestionDto.Response(4L,1L, "Title4", "Body4", tagList, LocalDateTime.now(), LocalDateTime.now(), 0, 0, answers);
        QuestionDto.Response response5 = new QuestionDto.Response(5L,1L, "Title5", "Body5", tagList, LocalDateTime.now(), LocalDateTime.now(), 0, 0, answers);
        QuestionDto.Response response6 = new QuestionDto.Response(6L,1L, "Title6", "Body6", tagList, LocalDateTime.now(), LocalDateTime.now(), 0, 0, answers);
        QuestionDto.Response response7 = new QuestionDto.Response(7L,1L, "Title7", "Body7", tagList, LocalDateTime.now(), LocalDateTime.now(), 0, 0, answers);
        QuestionDto.Response response8 = new QuestionDto.Response(8L,1L, "Title8", "Body8", tagList, LocalDateTime.now(), LocalDateTime.now(), 0, 0, answers);
        QuestionDto.Response response9 = new QuestionDto.Response(9L,1L, "Title9", "Body9", tagList, LocalDateTime.now(), LocalDateTime.now(), 0, 0, answers);
        QuestionDto.Response response10 = new QuestionDto.Response(10L,1L, "Title10", "Body10", tagList, LocalDateTime.now(), LocalDateTime.now(), 0, 0, answers);

        return List.of(response1, response2, response3, response4, response5, response6, response7, response8, response9, response10);
    }

}
