package com.example.practise.security;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.practise.entities.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component

public class AuthUtil {
    @Value("${jwt.secret}")
    private String secretKey;

    private SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }

    public String gernerateAccessToken(User user) {
        return Jwts.builder()
        .subject(user.getUsername())
        .claim("userId", user.getId().toString())
        .issuedAt(new Date())
        .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 10))
        .signWith(getSecretKey())
        .compact();
    }

    public String getUsernameFromToken(String token) {
        Claims claim = Jwts.parser().verifyWith(getSecretKey())
                            .build().parseSignedClaims(token)
                            .getPayload();
        return claim.getSubject();
    }
}