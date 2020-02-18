package com.zjw.community.domain;

import lombok.Data;

@Data
public class Topic {

    private int id;
    private String title;
    private String description;
    private Long gmtCreate;
    private Long gmtModify;
    private int creator;
    private String tag;

}
