package com.courseori.preproject.user.repository;

import com.courseori.preproject.question.entity.Question;
import com.courseori.preproject.user.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
}
