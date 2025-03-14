package com.nhnacademy.blogapi.post.dto;

import jakarta.validation.constraints.NotEmpty;

public class PostUpdateRequest {

    @NotEmpty
    private final String title;

    @NotEmpty
    private final String content;

    public PostUpdateRequest(String title, String content) {
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
