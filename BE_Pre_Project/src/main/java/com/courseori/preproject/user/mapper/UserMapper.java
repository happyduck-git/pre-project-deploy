package com.courseori.preproject.user.mapper;

import com.courseori.preproject.user.dto.UserDto;
import com.courseori.preproject.user.entity.Users;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    Users userPostDtoToUser(UserDto.Post post);

//    Users userPatchDtoToUser(UserDto.Patch patch);

    UserDto.Response userToUserResponse(Users users);

    List<UserDto.Response> usersToUserResponses(List<Users> users);
}
