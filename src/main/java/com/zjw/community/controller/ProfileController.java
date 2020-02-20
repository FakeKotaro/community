package com.zjw.community.controller;

import com.zjw.community.domain.Topic;
import com.zjw.community.domain.User;
import com.zjw.community.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/profile/{action}")
    public String profile(@PathVariable(name = "action") String action,
                          Model model,
                          @RequestParam(value = "page",defaultValue = "1") int page,
                          HttpServletRequest request) {
        if ("topics".equals(action)) {
            model.addAttribute("section" , "topics");
            model.addAttribute("sectionName" , "我的主题");
        } else if ("comments".equals(action)) {
            model.addAttribute("section" , "comments");
            model.addAttribute("sectionName" , "最新回复");
        }
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/";
        }
        List<Topic> topics = topicService.getTopicsByUser(user , (page - 1) * 5);
        int total = topicService.getTopicsByUser(user).size();
        int maxPage = (int) Math.ceil(total / 5.0);
        model.addAttribute("page" , page);
        model.addAttribute("topics" , topics);
        model.addAttribute("total" , total);
        model.addAttribute("maxPage" , maxPage);
        return "profile";
    }
}
