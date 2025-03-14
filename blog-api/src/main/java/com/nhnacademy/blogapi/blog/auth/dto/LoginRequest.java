package com.nhnacademy.blogapi.blog.auth.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class LoginRequest {
    String userName;
    String password;


    public String getUsername() {
        return userName;
    }
}
