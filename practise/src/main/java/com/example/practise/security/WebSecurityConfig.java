package com.example.practise.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // Good practice to add this
@RequiredArgsConstructor
public class WebSecurityConfig {

        @Bean
        public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
                return config.getAuthenticationManager();
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
                httpSecurity.csrf(csrf -> csrf.disable())
                                .sessionManagement(sessionconfig -> sessionconfig
                                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Disable for
                                                                                                         // REST APIs
                                .authorizeHttpRequests(auth -> auth
                                                .requestMatchers("/auth/**").permitAll() // Allow auth endpoints
                                                .anyRequest().authenticated() // Protect others
                                );
                return httpSecurity.build();
        }
}