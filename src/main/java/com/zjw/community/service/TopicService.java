package com.zjw.community.service;

import com.zjw.community.domain.Topic;
import com.zjw.community.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TopicService {

    void publish(Topic topic);

    List<Topic> getAllTopicsByPage(int page);

    List<Topic> getAllTopics();

    List<Topic> getTopicsByUser(User user , int page);

    List<Topic> getTopicsByUser(User user);

}
