package com.courseori.preproject.user.mapper;

import com.courseori.preproject.user.dto.UserDto;
import com.courseori.preproject.user.entity.Users;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-29T15:47:14+0900",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.15 (Azul Systems, Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public Users userPostDtoToUser(UserDto.Post post) {
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

    @Override
    public List<UserDto.Response> usersToUserResponses(List<Users> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDto.Response> list = new ArrayList<UserDto.Response>( users.size() );
        for ( Users users1 : users ) {
            list.add( userToUserResponse( users1 ) );
        }

        return list;
    }
}
