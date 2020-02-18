package com.zjw.community.controller;

import com.zjw.community.domain.User;
import com.zjw.community.dto.AccessTokenDTO;
import com.zjw.community.dto.GithubUser;
import com.zjw.community.provider.GithubProvider;
import com.zjw.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Autowired
    private UserService userService;

    @Value("${github.client.id}")
    private String cilentId;

    @Value("${github.client.secret}")
    private String cilentSecret;

    @Value("${github.redirect.uri}")
    private String redirectUri;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletResponse response) {

        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(cilentId);
        accessTokenDTO.setClient_secret(cilentSecret);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        String githubToken = githubProvider.getToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.getGithubUser(githubToken);
        if (githubUser != null) {
            String token = UUID.randomUUID().toString();
            User user = new User();
            user.setAccountId(githubUser.getId().toString());
            user.setName(githubUser.getName());
            user.setToken(token);
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModify(user.getGmtCreate());
            user.setAvatarUrl(githubUser.getAvatarUrl());
            userService.insertUser(user);
            response.addCookie(new Cookie("token" , token));
            return "redirect:/";
        }
        else {
            return "redirect:/";
        }
    }
}
