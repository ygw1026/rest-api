package com.nhnacademy.blogapi.topic.service;

import com.nhnacademy.blogapi.topic.dto.TopicResponse;

import java.util.List;

public interface TopicService {
    List<TopicResponse> getRootTopics();
    List<TopicResponse> getSubTopics(int parentTopicId);
}
