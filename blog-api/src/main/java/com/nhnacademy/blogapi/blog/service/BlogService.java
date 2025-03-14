package com.nhnacademy.blogapi.blog.service;

import com.nhnacademy.blogapi.blog.domain.Blog;
import com.nhnacademy.blogapi.blog.dto.BlogCreateRequest;
import com.nhnacademy.blogapi.blog.dto.BlogResponse;
import com.nhnacademy.blogapi.blog.dto.BlogUpdateRequest;

public interface BlogService {

    Blog createMainBlog(BlogCreateRequest blogCreateRequest);

    BlogResponse getBlog(Long blogId);

    void saveBlog(Blog blog);

    BlogResponse updateBlog(Long blogId, BlogUpdateRequest blogUpdateRequest);

    void deleteBlog(Long blogId);
}
