package com.zjw.community.controller;

import com.zjw.community.dto.AccessTokenDTO;
import com.zjw.community.dto.GithubUser;
import com.zjw.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String cilentId;

    @Value("${github.client.secret}")
    private String cilentSecret;

    @Value("${github.redirect.uri}")
    private String redirectUri;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state) {

        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(cilentId);
        accessTokenDTO.setClient_secret(cilentSecret);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        String token = githubProvider.getToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.getGithubUser(token);
        System.out.println(githubUser);
        return "index";
    }
}
