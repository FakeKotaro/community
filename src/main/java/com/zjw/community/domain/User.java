package com.zjw.community.domain;

import lombok.Data;

@Data
public class User {

    private int id;
    private String accountId;
    private String name;
    private String token;
    private Long gmtCreate;
    private Long gmtModify;
    private String avatarUrl;

}
