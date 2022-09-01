//package com.courseori.preproject.users.controller;
//
//import com.courseori.preproject.users.dto.UserDto;
//import com.courseori.preproject.users.entity.Users;
//import com.courseori.preproject.users.mapper.UsersMapper;
//import com.courseori.preproject.users.service.UsersService;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.jayway.jsonpath.JsonPath;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
//import org.springframework.http.MediaType;
//import org.springframework.restdocs.payload.JsonFieldType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import static org.mockito.BDDMockito.given;
//import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
//import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
//import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
//import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
//import static org.springframework.restdocs.payload.PayloadDocumentation.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//@WebMvcTest(UsersController.class)
//@MockBean(JpaMetamodelMappingContext.class)
//@AutoConfigureRestDocs
//class UsersControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private Gson gson = new GsonBuilder().serializeNulls().create();
//
//    @MockBean
//    private UsersService usersService;
//
//    @MockBean
//    private UsersMapper mapper;
//
//    @Test
//    void postUser() throws Exception{
//
//        //given
//        UserDto.Post post = new UserDto.Post("김길동","테스트");
//
//        String content = gson.toJson(post);
//
//        UserDto.Response responseBody = new UserDto.Response(1L,"김길동", LocalDateTime.now());
//
//        given(mapper.usersPostDtoToUser(Mockito.any(UserDto.Post.class))).willReturn(new Users());
//        given(usersService.createUser(Mockito.any(Users.class))).willReturn(new Users());
//        given(mapper.userToUserResponse(Mockito.any(Users.class))).willReturn(responseBody);
//
//        //when
//        ResultActions actions =
//                mockMvc.perform(
//                        post("/users")
//                                .accept(MediaType.APPLICATION_JSON)
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(content)
//                );
//
//        //then
//
//        actions
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.username").value(post.getUsername()))
//                .andDo(document("post-user",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        requestFields(
//                                List.of(
//                                        fieldWithPath("username").type(JsonFieldType.STRING).description("유저 이름"),
//                                        fieldWithPath("password").type(JsonFieldType.STRING).description("비밀번호")
//                                )
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("userId").type(JsonFieldType.NUMBER).description("유저 식별자"),
//                                        fieldWithPath("username").type(JsonFieldType.STRING).description("유저 이름"),
//                                        fieldWithPath("joinedAt").type(JsonFieldType.STRING).description("가입일자")
//                                )
//                        )
//                ));
//
//    }
//}