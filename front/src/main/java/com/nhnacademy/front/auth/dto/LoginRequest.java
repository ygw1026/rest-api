package com.nhnacademy.front.auth.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class LoginRequest {
    String userName;
    String password;

    @JsonCreator
    public LoginRequest(
            @JsonProperty("name") String userName,
            @JsonProperty("password") String password
    ) {
        this.userName = userName;
        this.password = password;
    }
}
