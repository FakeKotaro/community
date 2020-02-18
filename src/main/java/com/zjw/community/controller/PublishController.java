package com.zjw.community.controller;

import com.zjw.community.domain.Topic;
import com.zjw.community.domain.User;
import com.zjw.community.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/publish")
    public String publish(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/";
        }
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(@RequestParam(name = "title") String title,
                            @RequestParam(name = "description") String desc,
                            @RequestParam(name = "tag") String tag,
                            HttpServletRequest request,
                            Model model) {

        if (title == null || title == "") {
            model.addAttribute("error" , "标题不能为空！");
        }
        if (desc == null || desc == "") {
            model.addAttribute("error" , "内容不能为空！");
        }
        if (tag == null || tag == "") {
            model.addAttribute("error" , "标签不能为空！");
        }
        User user = (User) request.getSession().getAttribute("user");
        Topic topic = new Topic();
        topic.setTitle(title);
        topic.setDescription(desc);
        topic.setTag(tag);
        topic.setCreator(user.getId());
        topic.setGmtCreate(System.currentTimeMillis());
        topic.setGmtModify(topic.getGmtCreate());
        topicService.publish(topic);
        return "redirect:/";
    }
}
