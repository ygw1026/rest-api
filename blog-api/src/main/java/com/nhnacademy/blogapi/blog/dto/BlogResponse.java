package com.nhnacademy.blogapi.blog.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class BlogResponse {

    private final Long blogId;

    private final String blogFid;

    private final String blogName;


//    public BlogResponse(Long blogId, String blogFid, String blogName) {
//        this.blogId = blogId;
//        this.blogFid = blogFid;
//        this.blogName = blogName;
//    }

    public Long getBlogId() {
        return blogId;
    }

    public String getBlogFid() {
        return blogFid;
    }

    public String getBlogName() {
        return blogName;
    }


}