package com.nhnacademy.blogapi.blog.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.ToString;
import lombok.Value;

@Value
@ToString
public class BlogUpdateRequest {

    @NotEmpty(message="블로그 이름을 입력해주세요.")
    @Size(min=2, max=40, message="블로그 이름은 2자 이상 20자 이하로 입력해주세요")
    String blogName;

    @NotEmpty(message="블로그 닉네임을 입력해주세요.")
    String blogNickname;

    String blogDescription;

    Boolean blogIsPublic;
}
