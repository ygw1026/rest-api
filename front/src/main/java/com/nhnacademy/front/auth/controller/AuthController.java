package com.nhnacademy.front.auth.controller;

import com.nhnacademy.front.auth.adaptor.AuthAdaptor;
import com.nhnacademy.front.auth.dto.LoginRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class AuthController {

    @Autowired
    private final AuthAdaptor authAdaptor;

    public AuthController(AuthAdaptor authAdaptor){
        this.authAdaptor = authAdaptor;
    }

    @GetMapping(value="/login")
    public String login() {
        return "/auth/login";
    }

    public String login(LoginRequest loginRequest){
        authAdaptor.login(loginRequest);

        return "redirect:/";
    }
}
