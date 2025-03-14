package com.nhnacademy.blogapi.blog.service.impl;

import com.nhnacademy.blogapi.blog.domain.Blog;
import com.nhnacademy.blogapi.blog.dto.BlogCreateRequest;
import com.nhnacademy.blogapi.blog.dto.BlogResponse;
import com.nhnacademy.blogapi.blog.dto.BlogUpdateRequest;
import com.nhnacademy.blogapi.blog.exception.AlreadyExistBlogFidException;
import com.nhnacademy.blogapi.blog.exception.BlogNotFoundException;
import com.nhnacademy.blogapi.blog.repository.BlogRepository;
import com.nhnacademy.blogapi.blog.service.BlogService;
import com.nhnacademy.blogapi.blogmember.repository.BlogMemberMappingRepository;
import com.nhnacademy.blogapi.common.exception.ConflictException;
import com.nhnacademy.blogapi.common.exception.NotFoundException;
import com.nhnacademy.blogapi.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;
    private final BlogMemberMappingRepository blogMemberMappingRepository;
    private final MemberRepository memberRepository;
//d
    @Override
    public Blog createMainBlog(BlogCreateRequest blogCreateRequest) {
        Blog blog = blogRepository.findByBlogFid(blogCreateRequest.getBlogFid());
        if(blogRepository.existsByBlogFid(blog.getBlogFid())){
            throw new ConflictException(String.format("blogFid {} already exist!".formatted(blog.getBlogFid())));
        }

        return Blog.ofNewBlog(
                blogCreateRequest.getBlogFid(),
                true,
                blogCreateRequest.getBlogName() + "'s blog",
                blogCreateRequest.getBlogNickname(),
                blogCreateRequest.getBlogDescription()
        );
    }


    @Override
    public BlogResponse getBlog(Long blogId) {

//        Optional<Blog> optionalBlog = blogRepository.findById(blogId);
        Blog blog = blogRepository.findById(blogId).orElseThrow(()->new BlogNotFoundException(blogId));

        return blogResponseMapper(blog);
    }

    @Override
    public void saveBlog(Blog blog) {
    }

    @Override
    public BlogResponse updateBlog(Long blogId, BlogUpdateRequest blogUpdateRequest) {
        Blog blog = blogRepository.findById(blogId).orElseThrow(()->new BlogNotFoundException(blogId));
        blog.update(blogUpdateRequest.getBlogName(),blogUpdateRequest.getBlogNickname(), blogUpdateRequest.getBlogDescription(), blogUpdateRequest.getBlogIsPublic());

        return blogResponseMapper(blog);
    }

    @Override
    public void deleteBlog(Long blogId) {
        if(!blogRepository.existsById(blogId)){
            throw new BlogNotFoundException(blogId);
        }

        blogRepository.deleteById(blogId);
    }

    private BlogResponse blogResponseMapper(Blog blog){
        return new BlogResponse(
                blog.getBlogId(),
                blog.getBlogFid(),
                blog.getBlogName()
        );
    }
}
