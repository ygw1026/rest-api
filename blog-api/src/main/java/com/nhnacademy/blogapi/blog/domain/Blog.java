package com.nhnacademy.blogapi.blog.domain;


import com.nhnacademy.blogapi.blogmember.domain.BlogMemberMapping;
import com.nhnacademy.blogapi.category.domain.Category;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "blogs")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="blog_id",nullable = false)
    private Long blogId;

    @OneToMany(mappedBy = "blog", fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, orphanRemoval = true)
    @ToString.Exclude
    private List<Category> categories = new ArrayList<>();

    @OneToMany(mappedBy = "blog", fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, orphanRemoval = true)
    @ToString.Exclude
    private List<BlogMemberMapping> blogMemberMappings = new ArrayList<>();

    @Column(name="blog_fid",nullable = false, unique = true, length = 50)
    private String blogFid;

    @Column(nullable = false,columnDefinition = "tinyint")
    private boolean blogMain;

    @Column(nullable = false, length = 100)
    private String blogName;

    @Column(nullable = false, length = 100)
    private String blogMbNickname;

    @Column(columnDefinition = "text")
    private String blogDescription;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @Column(nullable = false, columnDefinition = "tinyint")
    private Boolean blogIsPublic = true;

    private Blog(String blogFid, boolean blogMain, String blogName, String blogMbNickname, String blogDescription, Boolean blogIsPublic) {
        this.blogFid = blogFid;
        this.blogMain = blogMain;
        this.blogName = blogName;
        this.blogMbNickname = blogMbNickname;
        this.blogDescription = blogDescription;
        this.blogIsPublic = blogIsPublic;
    }

    public static Blog ofNewBlog(String blogFid, Boolean blogMain, String blogName, String blogMbNickname, String blogDescription){
        return new Blog(
                blogFid,
                blogMain,
                blogName,
                blogMbNickname,
                blogDescription,
                true
        );
    }

    @PrePersist
    public void prePersist(){
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public void addCategory(Category category){
        categories.add(category);
        category.setBlog(this);
    }

    public void removeCategory(Category category){
        categories.remove(category);
        category.setBlog(null);
    }

    public void addBlogMemberMapping(BlogMemberMapping blogMemberMapping){
        blogMemberMappings.add(blogMemberMapping);
        blogMemberMapping.setBlog(this);
    }

    public void removeBlogMemberMapping(BlogMemberMapping blogMemberMapping){
        blogMemberMappings.remove(blogMemberMapping);
        blogMemberMapping.setBlog(null);
    }

    public void update(String blogName, String blogMbNickname, String blogDescription, Boolean blogIsPublic){
        this.blogName = blogName;
        this.blogMbNickname = blogMbNickname;
        this.blogDescription = blogDescription;
        this.blogIsPublic = blogIsPublic;
    }

    public void enableBlogPublicAccess(boolean blogIsPublic){
        this.blogIsPublic = blogIsPublic;
    }
}
