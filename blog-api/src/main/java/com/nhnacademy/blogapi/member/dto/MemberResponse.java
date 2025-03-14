package com.nhnacademy.blogapi.member.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MemberResponse {

    //회원_번호
    Long mbNo;
    //회원_이메일
    String mbEmail;
    //회원_이름
    String mbName;
    //모바일 연락처
    String mbMobile;

    //가입일자
    LocalDateTime createdAt;
    //수정일자
    LocalDateTime updatedAt;
    /// 탈퇴일자
    LocalDateTime withdrawalAt;

}