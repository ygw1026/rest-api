package com.nhnacademy.blogapi.blog.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.blogapi.blog.domain.Blog;
import com.nhnacademy.blogapi.blog.dto.BlogCreateRequest;
import com.nhnacademy.blogapi.blog.dto.BlogResponse;
import com.nhnacademy.blogapi.blog.dto.BlogUpdateRequest;
import com.nhnacademy.blogapi.blog.exception.BlogNotFoundException;
import com.nhnacademy.blogapi.blog.service.BlogService;
import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.validator.HibernateValidator;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@RestController
@RequestMapping(value = {"/api/blog/blogs"})
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    // /api/v1/blogs/1
    // /api/v1/blogs/bloginfo.do?blog_id=1
    @GetMapping("/{id}")
    public ResponseEntity<BlogResponse> getBlog(@PathVariable("id") Long blogId){
        BlogResponse blogResponse = blogService.getBlog(blogId);

        return ResponseEntity
                .ok(blogResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BlogResponse> putBlog(@PathVariable("id") Long blogId, @Validated @RequestBody BlogUpdateRequest blogUpdateRequest){
        BlogResponse blogResponse = blogService.updateBlog(blogId, blogUpdateRequest);

        return ResponseEntity
                .ok(blogResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable("id") Long blogId){
        blogService.deleteBlog(blogId);

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    @PostMapping
    public ResponseEntity<Blog> createMainBlog(@Validated @RequestBody BlogCreateRequest blogCreateRequest){
         return ResponseEntity
                 .status(HttpStatus.CREATED)
                 .body(blogService.createMainBlog(blogCreateRequest));
    }
}
