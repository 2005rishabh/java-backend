package com.jwt.security_with_jwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jwt.security_with_jwt.entity.User;

@Repository

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String username);
}
