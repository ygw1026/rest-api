package com.nhnacademy.blogapi.web.auth;

import com.nhnacademy.blogapi.blog.auth.dto.LoginRequest;
import com.nhnacademy.blogapi.blog.dto.BlogCreateRequest;
import com.nhnacademy.blogapi.common.security.service.JwtAuthenticationService;
import com.nhnacademy.blogapi.member.dto.MemberRegisterRequest;
import com.nhnacademy.blogapi.common.security.service.IntegrationService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtAuthenticationService jwtAuthenticationService;
    private final IntegrationService integrationService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest, HttpServletResponse response) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            // 로그인 성공 시 JWT를 쿠키에 저장
            jwtAuthenticationService.addJwtToCookie(response, loginRequest.getUsername());

            return ResponseEntity.ok().body("Login successful");
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    @RequestMapping(value = "/register.do")
    public String register() {
        return "member/register";
    }

    @PostMapping(value = "/registerAction.do")
    public String registerAction(@Validated MemberRegisterRequest memberRegisterRequest, RedirectAttributes redirectAttributes, BlogCreateRequest blogCreateRequest) {
        log.debug("memberRegisterRequest: {}", memberRegisterRequest);
        integrationService.registerMemberWithBlog(memberRegisterRequest, blogCreateRequest);
        redirectAttributes.addFlashAttribute("memberRegisterRequest", memberRegisterRequest);

        return "redirect:/member/registerResult.do";
    }

    @GetMapping(value = "/registerResult.do")
    public String registerResult(Model model) {
        log.debug("memberRegisterResult2: {}", model.getAttribute("memberRegisterRequest"));

        return "member/registerResult";
    }
}
