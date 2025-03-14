package com.nhnacademy.blogapi.topic.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTopic is a Querydsl query type for Topic
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTopic extends EntityPathBase<Topic> {

    private static final long serialVersionUID = -363684157L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTopic topic = new QTopic("topic");

    public final ListPath<Topic, QTopic> childrenTopics = this.<Topic, QTopic>createList("childrenTopics", Topic.class, QTopic.class, PathInits.DIRECT2);

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final QTopic parentTopic;

    public final NumberPath<Integer> topicId = createNumber("topicId", Integer.class);

    public final StringPath topicName = createString("topicName");

    public final NumberPath<Integer> topicSec = createNumber("topicSec", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public QTopic(String variable) {
        this(Topic.class, forVariable(variable), INITS);
    }

    public QTopic(Path<? extends Topic> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTopic(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTopic(PathMetadata metadata, PathInits inits) {
        this(Topic.class, metadata, inits);
    }

    public QTopic(Class<? extends Topic> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.parentTopic = inits.isInitialized("parentTopic") ? new QTopic(forProperty("parentTopic"), inits.get("parentTopic")) : null;
    }

}

