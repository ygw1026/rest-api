package com.nhnacademy.blogapi.topic.service.impl;

import com.nhnacademy.blogapi.topic.domain.Topic;
import com.nhnacademy.blogapi.topic.dto.TopicResponse;
import com.nhnacademy.blogapi.topic.repository.TopicRepository;
import com.nhnacademy.blogapi.topic.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {
    private final TopicRepository topicRepository;
    
    @Override
    public List<TopicResponse> getRootTopics() {
        List<Topic> topics = topicRepository.findTopicsByParentTopicIsNullOrderByTopicSecAsc();
        return convertToTopicResponse(topics);
    }

    @Override
    public List<TopicResponse> getSubTopics(int topicId) {
        List<Topic> topics = topicRepository.findTopicsByParentTopic_topicIdOrderByTopicSecAsc(topicId);
        return convertToTopicResponse(topics);
    }


    private List<TopicResponse> convertToTopicResponse(List<Topic> topics) {
        List<TopicResponse> topicResponses = new ArrayList<>();
        for (Topic topic : topics) {
            topicResponses.add(
                    new TopicResponse(
                            topic.getTopicId(),
                            null,
                            topic.getTopicName(),
                            topic.getTopicSec()
                    )
            );
        }
        return topicResponses;
    }
}
