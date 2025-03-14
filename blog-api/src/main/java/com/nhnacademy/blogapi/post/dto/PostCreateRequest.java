package com.nhnacademy.blogapi.post.dto;

import jakarta.validation.constraints.NotEmpty;

public class PostCreateRequest {

    @NotEmpty
    private final String title;

    @NotEmpty
    private final String content;

    public PostCreateRequest(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
