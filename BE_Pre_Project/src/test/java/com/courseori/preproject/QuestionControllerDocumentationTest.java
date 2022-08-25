package com.courseori.preproject;


import com.courseori.preproject.helper.StubData;
import com.courseori.preproject.question.controller.QuestionController;
import com.courseori.preproject.question.dto.QuestionDto;
import com.courseori.preproject.question.entity.Question;
import com.courseori.preproject.question.mapper.QuestionMapper;
import com.courseori.preproject.question.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;

import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(QuestionController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
public class QuestionControllerDocumentationTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private QuestionService questionService;
    @MockBean
    private QuestionMapper questionMapper;

    @Test
    public void getQuestionTest() throws Exception {

        //given
        given(questionService.findQuestion(Mockito.anyLong())).willReturn(new Question());

    }

    @Test
    public void getQuestionsTest() throws Exception {

        //given
        String page = "1";
        String size = "10";

        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("page", page);
        queryParams.add("size", size);

        Page<Question> questionPage = StubData.getMultiResultQuestion();
        List<QuestionDto .Response> responses = StubData.getMultiResponseBody();

        given(questionService.findQuestions(Mockito.anyInt(), Mockito.anyInt())).willReturn(questionPage);
        given(questionMapper.questionsToQuestionResponses(Mockito.anyList())).willReturn(responses);


        //when
        ResultActions actions = mockMvc.perform(
                get("/questions")
                        .params(queryParams)
                        .accept(MediaType.APPLICATION_JSON)

        );

        //then
        MvcResult result =
                actions
                        .andExpect(status().isOk())
                        .andDo(
                                document(
                                        "get-questions",
                                        preprocessRequest(prettyPrint()),
                                        preprocessResponse(prettyPrint()),
                                        requestParameters(
                                                List.of(
                                                        parameterWithName("page").description("Page 번호"),
                                                        parameterWithName("size").description("Page 사이즈")
                                                )
                                        ),
                                        responseFields(
                                                List.of(
                                                        fieldWithPath("[].questionId").type(JsonFieldType.NUMBER).description("게시글 식별자"),
                                                        fieldWithPath("[].userId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                                        fieldWithPath("[].title").type(JsonFieldType.STRING).description("타이틀"),
                                                        fieldWithPath("[].body").type(JsonFieldType.STRING).description("내용"),
                                                        fieldWithPath("[].tagList").type(JsonFieldType.ARRAY).description("태그"),
                                                        fieldWithPath("[].createdAt").type(JsonFieldType.STRING).description("생성 일자"),
                                                        fieldWithPath("[].modifiedAt").type(JsonFieldType.STRING).description("수정 일자"),
                                                        fieldWithPath("[].views").type(JsonFieldType.NUMBER).description("조회수"),
                                                        fieldWithPath("[].votes").type(JsonFieldType.NUMBER).description("공감수"),
                                                        fieldWithPath("[].answerList").type(JsonFieldType.ARRAY).description("답변")
                                                )
                                        )
                                )
                        ).andReturn();
    }
}





























