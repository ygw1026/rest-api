package com.nhnacademy.blogapi.post.exception;

public class PostNotFoundException extends RuntimeException{
    public PostNotFoundException(long postId){
        super("Post with %s not found".formatted(postId));
    }
}
