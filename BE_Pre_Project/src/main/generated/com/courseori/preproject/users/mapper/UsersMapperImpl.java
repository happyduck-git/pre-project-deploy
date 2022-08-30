package com.courseori.preproject.users.mapper;

import com.courseori.preproject.users.dto.UserDto;
import com.courseori.preproject.users.entity.Users;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-29T16:34:47+0900",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.15 (Azul Systems, Inc.)"
)
@Component
public class UsersMapperImpl implements UsersMapper {

    @Override
    public Users usersPostDtoToUser(UserDto.Post post) {
        if ( post == null ) {
            return null;
        }

        Users users = new Users();

        users.setUsername( post.getUsername() );
        users.setPassword( post.getPassword() );

        return users;
    }

    @Override
    public UserDto.Response userToUserResponse(Users users) {
        if ( users == null ) {
            return null;
        }

        long userId = 0L;
        String username = null;
        LocalDateTime joinedAt = null;

        userId = users.getUserId();
        username = users.getUsername();
        joinedAt = users.getJoinedAt();

        UserDto.Response response = new UserDto.Response( userId, username, joinedAt );

        return response;
    }
}
