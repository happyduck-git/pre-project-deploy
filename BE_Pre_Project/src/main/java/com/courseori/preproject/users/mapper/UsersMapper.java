package com.courseori.preproject.users.mapper;

import com.courseori.preproject.users.dto.UserDto;
import com.courseori.preproject.users.entity.Users;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsersMapper {

    Users usersPostDtoToUser(UserDto.Post post);

//    Users userPatchDtoToUser(UserDto.Patch patch);

    UserDto.Response userToUserResponse(Users users);

//    List<UserDto.Response> usersToUserResponses(List<Users> users);
}
