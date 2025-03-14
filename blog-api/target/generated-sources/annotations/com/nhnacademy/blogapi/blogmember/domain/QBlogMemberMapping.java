package com.nhnacademy.blogapi.blogmember.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBlogMemberMapping is a Querydsl query type for BlogMemberMapping
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBlogMemberMapping extends EntityPathBase<BlogMemberMapping> {

    private static final long serialVersionUID = 1425436507L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBlogMemberMapping blogMemberMapping = new QBlogMemberMapping("blogMemberMapping");

    public final com.nhnacademy.blogapi.blog.domain.QBlog blog;

    public final NumberPath<Long> blogMemberId = createNumber("blogMemberId", Long.class);

    public final com.nhnacademy.blogapi.member.domain.QMember member;

    public final com.nhnacademy.blogapi.role.doamin.QRole role;

    public QBlogMemberMapping(String variable) {
        this(BlogMemberMapping.class, forVariable(variable), INITS);
    }

    public QBlogMemberMapping(Path<? extends BlogMemberMapping> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBlogMemberMapping(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBlogMemberMapping(PathMetadata metadata, PathInits inits) {
        this(BlogMemberMapping.class, metadata, inits);
    }

    public QBlogMemberMapping(Class<? extends BlogMemberMapping> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.blog = inits.isInitialized("blog") ? new com.nhnacademy.blogapi.blog.domain.QBlog(forProperty("blog")) : null;
        this.member = inits.isInitialized("member") ? new com.nhnacademy.blogapi.member.domain.QMember(forProperty("member")) : null;
        this.role = inits.isInitialized("role") ? new com.nhnacademy.blogapi.role.doamin.QRole(forProperty("role")) : null;
    }

}

