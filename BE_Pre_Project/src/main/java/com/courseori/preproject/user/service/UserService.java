package com.courseori.preproject.user.service;

import com.courseori.preproject.user.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.courseori.preproject.user.repository.UsersRepository;


@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users createUser(Users users){
        Users postUser = usersRepository.save(users);

        return postUser;
    }
}
