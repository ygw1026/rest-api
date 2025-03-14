package com.nhnacademy.blogapi.blog.repository;

import com.nhnacademy.blogapi.blog.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog,Long>, CustomBlogRepository {
    Blog findByBlogFid(String blogFid);
    boolean existsByBlogFid(String blogFid);
}
