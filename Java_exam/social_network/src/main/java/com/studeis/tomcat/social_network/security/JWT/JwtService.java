package com.studeis.tomcat.social_network.security.JWT;

import com.studeis.tomcat.social_network.models.User;
import com.studeis.tomcat.social_network.repositories.UserRepository;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    private final UserRepository userRepository;
    private final String SECRET = "my_super_secret_key_12345678901234567890";
    private final long EXPIRATION = 1000 * 60 * 60 * 24;

    public  JwtService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private Key getSignKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    public String generateToken(String username) {
        User user = userRepository.findByUsername(username).get();

        return Jwts.builder()
                .setSubject(username)
                // add a role to a token
                .claim("roles", user.getRoles())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean isValid(String token) {
        try {
            extractUsername(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}