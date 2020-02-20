package com.zjw.community.service;

import com.zjw.community.domain.Topic;
import com.zjw.community.domain.User;
import com.zjw.community.mapper.TopicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicMapper topicMapper;

    @Override
    public void publish(Topic topic) {
        topicMapper.publish(topic);
    }

    @Override
    public List<Topic> getAllTopicsByPage(int page) {
        return topicMapper.getAllTopicsByPage(page);
    }

    @Override
    public List<Topic> getAllTopics() {
        return topicMapper.getAllTopics();
    }

    @Override
    public List<Topic> getTopicsByUser(User user , int page) {
        return topicMapper.getTopicsByUserAndPage(user.getId() , page);
    }

    @Override
    public List<Topic> getTopicsByUser(User user) {
        return topicMapper.getTopicsByUser(user.getId());
    }


}
