package com.zjw.community.mapper;

import com.zjw.community.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

    void insertUser(User user);

    User findUserByToken(@Param("token") String token);
}
