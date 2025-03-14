package com.nhnacademy.front.auth.adaptor;

import com.nhnacademy.front.auth.dto.LoginRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="authAdaptor", url="http://localhost:8080", path="/api")
public interface AuthAdaptor {

    @PostMapping("/login")
    ResponseEntity<?> login(@RequestBody LoginRequest loginRequest);
}
