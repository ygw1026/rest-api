package com.nhnacademy.blogapi.post.repository;

import com.nhnacademy.blogapi.post.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepostiory extends JpaRepository<Post, Long> {
    Page<Post> findAllByBlog_BlogIdOrderByCreatedAtDesc(Long blogBlogId, Pageable pageable);
}