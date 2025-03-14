package com.nhnacademy.blogapi.post.service;

import com.nhnacademy.blogapi.post.dto.CommonListResult;
import com.nhnacademy.blogapi.post.dto.PostCreateRequest;
import com.nhnacademy.blogapi.post.dto.PostResponse;
import com.nhnacademy.blogapi.post.dto.PostUpdateRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {

    PostResponse createPost(long blogId, PostCreateRequest postCreateRequest);

    PostResponse getPost(long postId);

    Page<PostResponse> getPostList(long blogId, Pageable pageable);

    PostResponse updatePost(long postId, PostUpdateRequest postUpdateRequest);

    void deletePost(long postId);

    CommonListResult<PostResponse> getCommonResultList(long blogId, Pageable pageable);
}