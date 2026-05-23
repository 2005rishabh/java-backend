package com.example.practise.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.practise.dto.LoginRequest;
import com.example.practise.dto.LoginResponse;
import com.example.practise.dto.SignupResponse;
import com.example.practise.entities.User;
import com.example.practise.repositries.UserRepository;
import com.example.practise.security.AuthUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder; // Add this

    public LoginResponse login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        User user = (User) authentication.getPrincipal();
        String token = authUtil.generateAccessToken(user);

        return new LoginResponse(token, user.getId());
    }

    public SignupResponse signup(LoginRequest signRequest) {
        // 1. Check if user already exists
        if (userRepository.findByUsername(signRequest.getUsername()).isPresent()) {
            throw new RuntimeException("User already exists with username: " + signRequest.getUsername());
        }

        // 2. Encode password and save new user
        User user = User.builder()
                .username(signRequest.getUsername())
                .password(passwordEncoder.encode(signRequest.getPassword())) // Encode here!
                .build();

        User savedUser = userRepository.save(user);

        return new SignupResponse(savedUser.getId(), savedUser.getUsername());
    }
}
