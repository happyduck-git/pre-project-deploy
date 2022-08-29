package com.courseori.preproject;

import com.courseori.preproject.question.repository.QuestionRepository;
import com.courseori.preproject.user.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PreprojectApplication {

	public static void main(String[] args) {



		SpringApplication.run(PreprojectApplication.class, args);
	}

}
