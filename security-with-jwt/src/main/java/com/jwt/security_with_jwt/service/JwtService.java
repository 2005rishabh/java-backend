package com.jwt.security_with_jwt.service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service

public class JwtService {
    @Value("${jwt.secret}")
    private String secretKey;

    //now we are going to create secret key
    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode((secretKey));
        return Keys.hmacShaKeyFor(keyBytes);
    }

    //now we are going to create token using jjwt
    public String generateToken(String username) {
        return Jwts.builder()
        .subject(username)
        .issuedAt(new Date(System.currentTimeMillis()))
        .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
        .signWith(getSigningKey())
        .compact();
    }

    public String exactUsername(String token) {
        return Jwts.parser()
        .verifyWith(getSigningKey())
        .build()
        .parseSignedClaims(token)
        .getPayload()
        .getSubject();
    }

    //now we are going to extract username from token
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = exactUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }



    //now we are going to extract username from token
    private boolean isTokenExpired(String token) {
        Date expiration = Jwts.parser()
        .verifyWith(getSigningKey())
        .build()
        .parseSignedClaims(token)
        .getPayload()
        .getExpiration();
        return expiration.before(new Date());
    }

}
