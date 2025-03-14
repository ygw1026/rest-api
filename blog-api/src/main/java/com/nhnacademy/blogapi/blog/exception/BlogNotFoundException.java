package com.nhnacademy.blogapi.blog.exception;

public class BlogNotFoundException extends RuntimeException {
    public BlogNotFoundException(Long blogId) {
        super("Blog not found %s".formatted(blogId));
    }
}
