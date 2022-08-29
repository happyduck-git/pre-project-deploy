package com.courseori.preproject.user.repository;

import com.courseori.preproject.user.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
