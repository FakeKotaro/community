package com.zjw.community.service;

import com.zjw.community.domain.Topic;
import com.zjw.community.mapper.TopicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicMapper topicMapper;

    @Override
    public void publish(Topic topic) {
        topicMapper.publish(topic);
    }
}
