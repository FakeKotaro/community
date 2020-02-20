package com.zjw.community.controller;

import com.zjw.community.domain.Topic;
import com.zjw.community.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/")
    public String Hello(HttpServletRequest request,
                        Model model,
                        @RequestParam(value = "page",defaultValue = "1") int page) {

        List<Topic> topics = topicService.getAllTopicsByPage((page - 1) * 5);
        int total = topicService.getAllTopics().size();
        int maxPage = (int) Math.ceil(total / 5.0);
        model.addAttribute("page" , page);
        model.addAttribute("topics" , topics);
        model.addAttribute("total" , total);
        model.addAttribute("maxPage" , maxPage);
        return "index";
    }
}
