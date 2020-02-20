package com.zjw.community.domain;

import lombok.Data;

@Data
public class Topic {

    private int id;
    private String title;
    private String description;
    private Long gmtCreate;
    private Long gmtModify;
    private String tag;
    private int commentCount;
    private int viewCount;
    private int likeCount;

    private User creator;
}
