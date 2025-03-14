package com.nhnacademy.blogapi.common.security.service;

import com.nhnacademy.blogapi.blog.domain.Blog;
import com.nhnacademy.blogapi.blog.dto.BlogCreateRequest;
import com.nhnacademy.blogapi.blog.service.BlogService;
import com.nhnacademy.blogapi.blogmember.domain.BlogMemberMapping;
import com.nhnacademy.blogapi.blogmember.service.BlogMemberMappingService;
import com.nhnacademy.blogapi.member.domain.Member;
import com.nhnacademy.blogapi.member.dto.MemberRegisterRequest;
import com.nhnacademy.blogapi.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class IntegrationService {
    private final MemberService memberService;
    private final BlogService blogService;
    private final BlogMemberMappingService blogMemberMappingService;

    public void registerMemberWithBlog(MemberRegisterRequest memberRegisterRequest, BlogCreateRequest blogCreateRequest) {
        Member member = memberService.registerMember(memberRegisterRequest);

        Blog blog = blogService.createMainBlog(blogCreateRequest);

        BlogMemberMapping blogMemberMapping = blogMemberMappingService.createBlogMemberMapping(member, blog);
        blog.addBlogMemberMapping(blogMemberMapping);

        blogService.saveBlog(blog);
    }
}
