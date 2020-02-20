package com.zjw.community.mapper;

import com.zjw.community.domain.Topic;
import com.zjw.community.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TopicMapper {

    void publish(Topic topic);

    List<Topic> getAllTopicsByPage(@Param("page") int page);

    List<Topic> getAllTopics();

    List<Topic> getTopicsByUserAndPage(@Param("user") int user , @Param("page") int page);

    List<Topic> getTopicsByUser(@Param("user") int user);
}
