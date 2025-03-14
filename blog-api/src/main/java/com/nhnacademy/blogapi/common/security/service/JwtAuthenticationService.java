package com.nhnacademy.blogapi.common.security.service;

import com.nhnacademy.blogapi.common.provider.JwtProvider;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtAuthenticationService {
    private final JwtProvider jwtProvider;

    public void addJwtToCookie(HttpServletResponse response, String userName) {
        String token = jwtProvider.generateToken(userName);

        Cookie cookie = new Cookie("jwt", token);
        cookie.setHttpOnly(true); // javaScript 접근 불가능
        cookie.setSecure(true); // HTTPS에서만 사용 가능
        cookie.setPath("/"); // 모든 경로에서 사용 가능
        cookie.setMaxAge(60 * 60); // 1시간 유지
        response.addCookie(cookie);
    }
}
