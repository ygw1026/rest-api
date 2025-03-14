package com.nhnacademy.blogapi.member.service;

import com.nhnacademy.blogapi.member.domain.Member;
import com.nhnacademy.blogapi.member.dto.MemberRegisterRequest;
import com.nhnacademy.blogapi.member.dto.MemberResponse;

public interface MemberService {
    //회원(등록)
    Member registerMember(MemberRegisterRequest memberRegisterRequest);
    MemberResponse getMember(long mbNo);
    MemberResponse getMemberByEmail(String mbEmail);
}
