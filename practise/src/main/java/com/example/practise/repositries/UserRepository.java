package com.example.practise.repositries;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.practise.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
