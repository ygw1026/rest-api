package com.nhnacademy.blogapi.member.controller;

import com.nhnacademy.blogapi.member.domain.Member;
import com.nhnacademy.blogapi.member.dto.MemberRegisterRequest;
import com.nhnacademy.blogapi.member.dto.MemberResponse;
import com.nhnacademy.blogapi.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blog/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/{member-no}")
    public ResponseEntity<MemberResponse> getMember(@PathVariable(value="member-no")Long memberNo){
        MemberResponse memberResponse = memberService.getMember(memberNo);
        return ResponseEntity.ok(memberResponse);
    }

    @PostMapping
    public ResponseEntity<Member> registerMember(@Valid @RequestBody MemberRegisterRequest memberRegisterRequest){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(memberService.registerMember(memberRegisterRequest));
    }
}
