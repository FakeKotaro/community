package com.zjw.community.mapper;

import com.zjw.community.domain.Topic;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TopicMapper {

    void publish(Topic topic);

}
