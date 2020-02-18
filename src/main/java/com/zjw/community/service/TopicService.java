package com.zjw.community.service;

import com.zjw.community.domain.Topic;
import org.springframework.stereotype.Service;

@Service
public interface TopicService {

    void publish(Topic topic);

}
