package com.nhnacademy.blogapi.blogmember.service.impl;

import com.nhnacademy.blogapi.blog.domain.Blog;
import com.nhnacademy.blogapi.blogmember.domain.BlogMemberMapping;
import com.nhnacademy.blogapi.blogmember.service.BlogMemberMappingService;
import com.nhnacademy.blogapi.common.exception.NotFoundException;
import com.nhnacademy.blogapi.member.domain.Member;
import com.nhnacademy.blogapi.role.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogMemberMappingServiceImpl implements BlogMemberMappingService {
    private final RoleRepository roleRepository;

    @Override
    public BlogMemberMapping createBlogMemberMapping(Member member, Blog blog) {

        return BlogMemberMapping.ofNewBlogMemberMapping(
                member,
                blog,
                roleRepository.findById("ROLE_OWNER").orElseThrow(() -> new NotFoundException("role_owner not found"))
        );
    }
}
