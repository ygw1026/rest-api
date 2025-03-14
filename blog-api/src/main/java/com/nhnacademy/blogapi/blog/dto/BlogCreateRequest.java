package com.nhnacademy.blogapi.blog.dto;

import lombok.*;

@ToString
@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class BlogCreateRequest {

    String blogFid;
    String blogName;
    String blogNickname;
    String blogDescription;
}
