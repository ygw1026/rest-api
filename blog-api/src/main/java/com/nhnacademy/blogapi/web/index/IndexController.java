package com.nhnacademy.blogapi.web.index;

import com.nhnacademy.blogapi.topic.dto.TopicResponse;
import com.nhnacademy.blogapi.topic.service.TopicService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/index")
public class IndexController {
    private final TopicService topicService;

    // 최상위 주제(rootTopics) 가져오기
    @GetMapping("/root-topics")
    public ResponseEntity<List<TopicResponse>> getRootTopics(){
        List<TopicResponse> rootTopics = topicService.getRootTopics();
        return ResponseEntity.ok()
                .header("Content-Type", "application/json")
                .body(rootTopics);
    }

    // 하위 주제(subTopics) 가져오기
    @GetMapping("/sub-topics")
    public ResponseEntity<List<TopicResponse>> getSubTopics(@RequestParam(value = "topic_id", required = false) Integer topicId) {
        if (Objects.isNull(topicId)) {
            return ResponseEntity.ok(Collections.emptyList());
        }
        List<TopicResponse> subTopics = topicService.getSubTopics(topicId);
        log.debug("subTopics: {}", subTopics);
        return ResponseEntity.ok()
                .header("Content-Type", "application/json")
                .body(subTopics);
    }
}
