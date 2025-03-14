package com.nhnacademy.blogapi.blog.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBlog is a Querydsl query type for Blog
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBlog extends EntityPathBase<Blog> {

    private static final long serialVersionUID = -33932513L;

    public static final QBlog blog = new QBlog("blog");

    public final StringPath blogDescription = createString("blogDescription");

    public final StringPath blogFid = createString("blogFid");

    public final NumberPath<Long> blogId = createNumber("blogId", Long.class);

    public final BooleanPath blogIsPublic = createBoolean("blogIsPublic");

    public final BooleanPath blogMain = createBoolean("blogMain");

    public final StringPath blogMbNickname = createString("blogMbNickname");

    public final ListPath<com.nhnacademy.blogapi.blogmember.domain.BlogMemberMapping, com.nhnacademy.blogapi.blogmember.domain.QBlogMemberMapping> blogMemberMappings = this.<com.nhnacademy.blogapi.blogmember.domain.BlogMemberMapping, com.nhnacademy.blogapi.blogmember.domain.QBlogMemberMapping>createList("blogMemberMappings", com.nhnacademy.blogapi.blogmember.domain.BlogMemberMapping.class, com.nhnacademy.blogapi.blogmember.domain.QBlogMemberMapping.class, PathInits.DIRECT2);

    public final StringPath blogName = createString("blogName");

    public final ListPath<com.nhnacademy.blogapi.category.domain.Category, com.nhnacademy.blogapi.category.domain.QCategory> categories = this.<com.nhnacademy.blogapi.category.domain.Category, com.nhnacademy.blogapi.category.domain.QCategory>createList("categories", com.nhnacademy.blogapi.category.domain.Category.class, com.nhnacademy.blogapi.category.domain.QCategory.class, PathInits.DIRECT2);

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public QBlog(String variable) {
        super(Blog.class, forVariable(variable));
    }

    public QBlog(Path<? extends Blog> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBlog(PathMetadata metadata) {
        super(Blog.class, metadata);
    }

}

