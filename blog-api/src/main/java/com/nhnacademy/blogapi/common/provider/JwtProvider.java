package com.nhnacademy.blogapi.common.provider;

import com.nhnacademy.blogapi.common.exception.UnauthorizedException;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.security.Keys;

@Component
public class JwtProvider {

    @Value("${jwt.secret}")
    private String secretKey; // JWT 서명용 비밀 키

    private final Key key; // HMAC SHA256 키.

    public JwtProvider(@Value("${jwt.secret}") String secretKey) {
        this.key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }

    // JWT 생성
    public String generateToken(String username) {
        // 1시간 (단위: 밀리초).
        long expirationTime = 1000 * 60 * 60;
        return Jwts.builder()
                .setSubject(username) // 사용자 정보 저장.
                .setIssuedAt(new Date()) // 발급 시간.
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime)) // 만료 시간.
                .signWith(key, SignatureAlgorithm.HS256) // 키를 사용하여 서명.
                .compact();
    }

    // JWT에서 사용자 이름 추출
    public String getUsernameFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // JWT 유효성 검사
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true; // 유효한 토큰이면 true 반환.
        } catch (ExpiredJwtException e) {
            throw new UnauthorizedException("토큰이 만료되었습니다.");
        } catch (MalformedJwtException | UnsupportedJwtException e) {
            throw new UnauthorizedException("유효하지 않은 토큰입니다.");
        } catch (IllegalArgumentException e) {
            throw new UnauthorizedException("토큰이 비어 있거나 잘못되었습니다.");
        }
    }
}
