package com.nhnacademy.blogapi.blogmember.service;

import com.nhnacademy.blogapi.blog.domain.Blog;
import com.nhnacademy.blogapi.blogmember.domain.BlogMemberMapping;
import com.nhnacademy.blogapi.member.domain.Member;

public interface BlogMemberMappingService {
    BlogMemberMapping createBlogMemberMapping(Member member, Blog blog);
}
