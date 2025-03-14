package com.nhnacademy.blogapi.post.dto;

import java.time.LocalDateTime;

public class PostResponse {

    private final Long postId;

    private final String title;

    private final String content;

    private final LocalDateTime createdAt;

    private final LocalDateTime updatedAt;

    public PostResponse(Long postId, String title, String content, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getPostId() {
        return postId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}