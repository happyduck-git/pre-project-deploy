//package com.courseori.preproject.util;
//
//import com.courseori.preproject.answer.entity.Answer;
//import com.courseori.preproject.helper.StubData;
//import com.courseori.preproject.question.controller.QuestionController;
//import com.courseori.preproject.question.dto.QuestionDto;
//import com.courseori.preproject.question.entity.Question;
//import com.courseori.preproject.question.mapper.QuestionMapper;
//import com.courseori.preproject.question.service.QuestionService;
//import com.google.gson.GsonBuilder;
//import org.junit.jupiter.api.Test;
//import com.google.gson.Gson;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.data.domain.Page;
//import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
//import org.springframework.http.MediaType;
//import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
//import org.springframework.restdocs.payload.JsonFieldType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import static com.courseori.preproject.util.ApiDocumentUtils.getRequestPreprocessor;
//import static com.courseori.preproject.util.ApiDocumentUtils.getResponsePreprocessor;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.doNothing;
//import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
//import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
//import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
//import static org.springframework.restdocs.payload.PayloadDocumentation.*;
//import static org.springframework.restdocs.request.RequestDocumentation.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(QuestionController.class)
//@MockBean(JpaMetamodelMappingContext.class)
//@AutoConfigureRestDocs
//class QuestionControllerTest {
//
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    //Gson null ??? ????????? ?????? builder ??????
//    @Autowired
//    private Gson gson = new GsonBuilder().serializeNulls().create();
//
//    @MockBean
//    private QuestionService questionService;
//
//    @MockBean
//    private QuestionMapper mapper;
//
//
//    @Test
//    void postQuestion() throws Exception{
//
//        //given
//        List<String> tagList = new ArrayList<>();
//        List<Answer> answerList = new ArrayList<>();
//
//        QuestionDto.Post post = new QuestionDto.Post(1L,"Title1","Body1",tagList,answerList);
//
//        String content = gson.toJson(post);
//        LocalDateTime time = LocalDateTime.now();
//
//        QuestionDto.Response responseBody = new QuestionDto.Response(1L,1L, "Title1", "Body1", tagList, time, time, 0, 0,answerList);
//
//        given(mapper.questionPostDtoToQuestion(Mockito.any(QuestionDto.Post.class))).willReturn(new Question());
//        given(questionService.createQuestion(Mockito.any(Question.class))).willReturn(new Question());
//        given(mapper.questionToQuestionResponse(Mockito.any(Question.class))).willReturn(responseBody);
//
//        //when
//        ResultActions actions =
//                mockMvc.perform(
//                        post("/questions")
//                                .accept(MediaType.APPLICATION_JSON)
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(content)
//                );
//
//
//        //then
//        actions
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.userId").value(post.getUserId()))
//                .andExpect(jsonPath("$.title").value(post.getTitle()))
//                .andExpect(jsonPath("$.body").value(post.getBody()))
//                .andExpect(jsonPath("$.tagList").value(post.getTagList()))
//                .andExpect(jsonPath("$.answerList").value(post.getAnswerList()))
//                .andDo(document("post-question",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        requestFields(
//                                List.of(
//                                        fieldWithPath("userId").type(JsonFieldType.NUMBER).description("?????? ?????????"),
//                                        fieldWithPath("title").type(JsonFieldType.STRING).description("?????????"),
//                                        fieldWithPath("body").type(JsonFieldType.STRING).description("??????"),
//                                        fieldWithPath("tagList").type(JsonFieldType.ARRAY).description("??????"),
//                                        fieldWithPath("answerList").type(JsonFieldType.ARRAY).description("??????")
//                                )
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("userId").type(JsonFieldType.NUMBER).description("?????? ?????????"),
//                                        fieldWithPath("questionId").type(JsonFieldType.NUMBER).description("??????????????? ?????????"),
//                                        fieldWithPath("title").type(JsonFieldType.STRING).description("?????????"),
//                                        fieldWithPath("body").type(JsonFieldType.STRING).description("??????"),
//                                        fieldWithPath("tagList").type(JsonFieldType.ARRAY).description("??????"),
//                                        fieldWithPath("createdAt").type(JsonFieldType.STRING).description("?????? ??????"),
//                                        fieldWithPath("modifiedAt").type(JsonFieldType.STRING).description("?????? ??????"),
//                                        fieldWithPath("views").type(JsonFieldType.NUMBER).description("?????????"),
//                                        fieldWithPath("votes").type(JsonFieldType.NUMBER).description("?????????"),
//                                        fieldWithPath("answerList").type(JsonFieldType.ARRAY).description("??????")
//
//                                )
//                        )
//                ));
//    }
//
//    @Test
//    void patchQuestion() throws Exception {
//
//        //given
//        List<String> tagList = new ArrayList<>();
//        List<Answer> answers = new ArrayList<>();
//
//        long userId = 1L;
//        long questionId = 1L;
//
//        QuestionDto.Patch patch = new QuestionDto.Patch(userId,questionId,"Title1","Body1",tagList);
//
//        String content = gson.toJson(patch);
//
//        QuestionDto.Response responseBody = new QuestionDto.Response(1L,1L, "Title1", "Body1", tagList, LocalDateTime.now(), LocalDateTime.now(), 0, 0,answers);
//
//        given(mapper.questionPatchDtoTOQuestion(Mockito.any(QuestionDto.Patch.class))).willReturn(new Question());
//        given(questionService.updateQuestion(Mockito.any(Question.class))).willReturn(new Question());
//        given(mapper.questionToQuestionResponse(Mockito.any(Question.class))).willReturn(responseBody);
//        //when
//
//        ResultActions actions =
//                mockMvc.perform(
//                        patch("/questions/{question-id}",questionId)
//                                .accept(MediaType.APPLICATION_JSON)
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(content)
//                );
//
//
//
//        //then
//        actions.andExpect(status().isAccepted())
//                .andExpect(jsonPath("$.userId").value(patch.getUserId()))
//                .andExpect(jsonPath("$.questionId").value(patch.getQuestionId()))
//                .andExpect(jsonPath("$.title").value(patch.getTitle()))
//                .andExpect(jsonPath("$.body").value(patch.getBody()))
//                .andExpect(jsonPath("$.tagList").value(patch.getTagList()))
//                .andDo(document("patch-question",
//                        getRequestPreprocessor(),
//                        getResponsePreprocessor(),
//                        pathParameters(
//                                parameterWithName("question-id").description("??????????????? ????????? ID")
//                        ),
//                        requestFields(
//                                List.of(
//                                        fieldWithPath("userId").type(JsonFieldType.NUMBER).description("?????? ?????????").ignored(),
//                                        fieldWithPath("questionId").type(JsonFieldType.NUMBER).description("??????????????? ?????????").ignored(),
//                                        fieldWithPath("title").type(JsonFieldType.STRING).description("?????????").optional(),
//                                        fieldWithPath("body").type(JsonFieldType.STRING).description("??????").optional(),
//                                        fieldWithPath("tagList").type(JsonFieldType.ARRAY).description("??????")
//                                )
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("userId").type(JsonFieldType.NUMBER).description("?????? ?????????"),
//                                        fieldWithPath("questionId").type(JsonFieldType.NUMBER).description("??????????????? ?????????"),
//                                        fieldWithPath("title").type(JsonFieldType.STRING).description("?????????"),
//                                        fieldWithPath("body").type(JsonFieldType.STRING).description("??????"),
//                                        fieldWithPath("tagList").type(JsonFieldType.ARRAY).description("??????"),
//                                        fieldWithPath("createdAt").type(JsonFieldType.STRING).description("?????? ??????"),
//                                        fieldWithPath("modifiedAt").type(JsonFieldType.STRING).description("?????? ??????"),
//                                        fieldWithPath("views").type(JsonFieldType.NUMBER).description("?????????"),
//                                        fieldWithPath("votes").type(JsonFieldType.NUMBER).description("?????????"),
//                                        fieldWithPath("answerList").type(JsonFieldType.ARRAY).description("??????")
//                                )
//                        )
//                ));
//    }
//
//    @Test
//    public void getQuestionTest() throws Exception {
//
//        //given
//        long questionId = 1L;
//        QuestionDto.Response response = StubData.getSingleResultBody();
//
//
//        given(questionService.findQuestion(Mockito.anyLong())).willReturn(new Question());
//        given(mapper.questionToQuestionResponse(Mockito.any(Question.class))).willReturn(response);
//
//        ResultActions actions = mockMvc.perform(
//                RestDocumentationRequestBuilders.get("/questions/{question-id}",questionId)
//                        .accept(MediaType.APPLICATION_JSON));
//
//        actions
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.questionId").value(questionId))
//                .andExpect(jsonPath("$.userId").value(response.getUserId()))
//                .andExpect(jsonPath("$.title").value(response.getTitle()))
//                .andExpect(jsonPath("$.body").value(response.getBody()))
//                .andExpect(jsonPath("$.tagList").value(response.getTagList()))
//                //.andExpect(jsonPath("$.createdAt").value(response.getCreatedAt()))
//                //.andExpect(jsonPath("$.modifiedAt").value(response.getModifiedAt()))
//                .andExpect(jsonPath("$.views").value(response.getViews()))
//                .andExpect(jsonPath("$.votes").value(response.getVotes()))
//                .andExpect(jsonPath("$.answerList").value(response.getAnswerList()))
//
//                .andDo(
//                        document(
//                                "get-question",
//                                preprocessRequest(prettyPrint()),
//                                preprocessResponse(prettyPrint()),
//                                pathParameters(
//                                        Arrays.asList(parameterWithName("question-id").description("????????? ?????????"))
//                                ),
//                                responseFields(
//                                        Arrays.asList(
//                                                fieldWithPath("questionId").type(JsonFieldType.NUMBER).description("????????? ?????????"),
//                                                fieldWithPath("userId").type(JsonFieldType.NUMBER).description("?????? ?????????"),
//                                                fieldWithPath("title").type(JsonFieldType.STRING).description("?????????"),
//                                                fieldWithPath("body").type(JsonFieldType.STRING).description("??????"),
//                                                fieldWithPath("tagList").type(JsonFieldType.ARRAY).description("??????"),
//                                                fieldWithPath("createdAt").type(JsonFieldType.STRING).description("?????? ??????"),
//                                                fieldWithPath("modifiedAt").type(JsonFieldType.STRING).description("?????? ??????"),
//                                                fieldWithPath("views").type(JsonFieldType.NUMBER).description("?????????"),
//                                                fieldWithPath("votes").type(JsonFieldType.NUMBER).description("?????????"),
//                                                fieldWithPath("answerList").type(JsonFieldType.ARRAY).description("??????")
//                                        )
//                                )
//                        ));
//
//    }
//
//    @Test
//    public void getQuestionsTest() throws Exception {
//
//        //given
//        String page = "1";
//        String size = "10";
//
//        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
//        queryParams.add("page", page);
//        queryParams.add("size", size);
//
//        Page<Question> questionPage = StubData.getMultiResultQuestion();
//        List<QuestionDto .Response> responses = StubData.getMultiResponseBody();
//
//        given(questionService.findQuestions(Mockito.anyInt(), Mockito.anyInt())).willReturn(questionPage);
//        given(mapper.questionsToQuestionResponses(Mockito.anyList())).willReturn(responses);
//
//
//        //when
//        ResultActions actions = mockMvc.perform(
//                get("/questions")
//                        .params(queryParams)
//                        .accept(MediaType.APPLICATION_JSON)
//
//        );
//
//        //then
//        MvcResult result =
//                actions
//                        .andExpect(status().isOk())
//                        .andDo(
//                                document(
//                                        "get-questions",
//                                        preprocessRequest(prettyPrint()),
//                                        preprocessResponse(prettyPrint()),
//                                        requestParameters(
//                                                List.of(
//                                                        parameterWithName("page").description("Page ??????"),
//                                                        parameterWithName("size").description("Page ?????????")
//                                                )
//                                        ),
//                                        responseFields(
//                                                List.of(
//                                                        fieldWithPath("[].questionId").type(JsonFieldType.NUMBER).description("????????? ?????????"),
//                                                        fieldWithPath("[].userId").type(JsonFieldType.NUMBER).description("?????? ?????????"),
//                                                        fieldWithPath("[].title").type(JsonFieldType.STRING).description("?????????"),
//                                                        fieldWithPath("[].body").type(JsonFieldType.STRING).description("??????"),
//                                                        fieldWithPath("[].tagList").type(JsonFieldType.ARRAY).description("??????"),
//                                                        fieldWithPath("[].createdAt").type(JsonFieldType.STRING).description("?????? ??????"),
//                                                        fieldWithPath("[].modifiedAt").type(JsonFieldType.STRING).description("?????? ??????"),
//                                                        fieldWithPath("[].views").type(JsonFieldType.NUMBER).description("?????????"),
//                                                        fieldWithPath("[].votes").type(JsonFieldType.NUMBER).description("?????????"),
//                                                        fieldWithPath("[].answerList").type(JsonFieldType.ARRAY).description("??????")
//                                                )
//                                        )
//                                )
//                        ).andReturn();
//    }
//
//    @Test
//    public void deleteQuestion() throws Exception {
//
//        //give
//        long questionId = 1L;
//        doNothing().when(questionService).deleteQuestion(Mockito.anyLong());
//        //when
//        ResultActions actions = mockMvc.perform(
//                RestDocumentationRequestBuilders
//                        .delete("/questions/{question-id}", questionId));
//
//        actions.andExpect(status().isNoContent())
//                .andDo(
//                        document(
//                                "delete-questions",
//                                preprocessRequest(prettyPrint()),
//                                preprocessResponse(prettyPrint()),
//                                pathParameters(
//                                        Arrays.asList(parameterWithName("question-id").description("????????? ?????????"))
//                                )
//                        )
//                );
//        //then
//    }
//}