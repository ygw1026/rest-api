package com.nhnacademy.blogapi.topic.repository;

import com.nhnacademy.blogapi.topic.domain.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Integer> {
    List<Topic> findTopicsByParentTopicIsNullOrderByTopicSecAsc();
    List<Topic> findTopicsByParentTopic_topicIdOrderByTopicSecAsc(Integer topicId);
}
