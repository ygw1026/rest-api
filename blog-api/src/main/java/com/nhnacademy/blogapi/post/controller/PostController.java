package com.nhnacademy.blogapi.post.controller;

import com.nhnacademy.blogapi.blog.dto.BlogResponse;
import com.nhnacademy.blogapi.blog.service.BlogService;
import com.nhnacademy.blogapi.post.dto.CommonListResult;
import com.nhnacademy.blogapi.post.dto.PostCreateRequest;
import com.nhnacademy.blogapi.post.dto.PostResponse;
import com.nhnacademy.blogapi.post.dto.PostUpdateRequest;
import com.nhnacademy.blogapi.post.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blog/blogs/{blog-id}/posts")
public class PostController {

    Logger log = LoggerFactory.getLogger(PostController.class);

    private final BlogService blogService;
    private final PostService postService;

    public PostController(BlogService blogService, PostService postService) {
        this.blogService = blogService;
        this.postService = postService;
    }

    @ModelAttribute("blogResponse")
    public BlogResponse getBlogId(@PathVariable(value = "blog-id", required = true) Long blogId){
        return blogService.getBlog(blogId);
    }

    @PostMapping
    public ResponseEntity<PostResponse> createPost(@ModelAttribute BlogResponse blogResponse,
                                                   @Validated @RequestBody PostCreateRequest createRequest){
        PostResponse postResponse = postService.createPost(blogResponse.getBlogId(), createRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(postResponse);
    }

    @GetMapping("/{post-id}")
    public ResponseEntity<PostResponse> getPost(@PathVariable("post-id") Long postId){
        PostResponse postResponse = postService.getPost(postId);
        return ResponseEntity
                .ok(postResponse);
    }

    @GetMapping
    public ResponseEntity<CommonListResult<PostResponse>> getPostList(@ModelAttribute BlogResponse blogResponse,
                                                          @PageableDefault(size = 10) Pageable pageable){

        CommonListResult<PostResponse> postResponsePage = postService.getCommonResultList(blogResponse.getBlogId(),pageable);
        return ResponseEntity
                .ok(postResponsePage);
    }

    @PutMapping("/{post-id}")
    public ResponseEntity<PostResponse> updatePost(@PathVariable("post-id") Long postId,
                                                   @Validated @RequestBody PostUpdateRequest postUpdateRequest){
        PostResponse postResponse = postService.updatePost(postId, postUpdateRequest);

        return ResponseEntity
                .ok(postResponse);
    }

    @DeleteMapping("/{post-id}")
    public ResponseEntity<Void> deletePost(@PathVariable("post-id") Long postId){
        postService.deletePost(postId);

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
