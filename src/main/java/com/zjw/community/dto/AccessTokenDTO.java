package com.zjw.community.dto;

import lombok.Data;
/*
    该包为数据传输模型
    该类为向github  post获取token时传输的信息包装
 */
@Data
public class AccessTokenDTO {

    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;

}
