package com.courseori.preproject.users.service;

import com.courseori.preproject.users.entity.Users;
import com.courseori.preproject.users.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users createUser(Users users){
        Users postUser = usersRepository.save(users);

        return postUser;
    }
}
