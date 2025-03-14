package com.nhnacademy.blogapi.blog.exception;

public class AlreadyExistBlogFidException extends RuntimeException {
    public AlreadyExistBlogFidException(String blogFid) {
        super("Already exist %s".formatted(blogFid));
    }
}
