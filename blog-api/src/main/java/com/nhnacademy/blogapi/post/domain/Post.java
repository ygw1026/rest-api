package com.nhnacademy.blogapi.post.domain;

import com.nhnacademy.blogapi.blog.domain.Blog;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "blog_id", referencedColumnName = "blog_id")
    private Blog blog;

    private String postTitle;

    private String postContent;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    protected Post(){}

    public Post(Blog blog, String postTitle, String postContent) {
        this.blog = blog;
        this.postTitle = postTitle;
        this.postContent = postContent;
    }

    @PrePersist
    public void prePersist(){
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        this.updatedAt = LocalDateTime.now();
    }

    public void update(String postTitle, String postContent){
        this.postTitle = postTitle;
        this.postContent = postContent;
    }

    public Long getPostId() {
        return postId;
    }

    public Blog getBlog() {
        return blog;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
