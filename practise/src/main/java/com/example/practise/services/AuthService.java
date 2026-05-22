package com.example.practise.services;

import org.jspecify.annotations.Nullable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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

    public LoginResponse login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        User user = (User) authentication.getPrincipal();

        String token = authUtil.gernerateAccessToken(user);

        return new LoginResponse(token, user.getId());
    }

    public SignupResponse signup(LoginRequest signRequest) {
        User user = userRepository.findByUsername(signRequest.getUsername())
        .orElseThrow(
            () -> new RuntimeException("Invalid username not found")
        );

        if(user != null) throw new IllegalArgumentException();

        user  = userRepository.save(user.builder()
                    .username(signRequest.getUsername())
                .password(signRequest.getPassword())
            .build());

        return new SignupResponse(user.getId(), user.getUsername());
    }
}
