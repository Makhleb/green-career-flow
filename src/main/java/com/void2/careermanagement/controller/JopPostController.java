package com.void2.careermanagement.controller;

import com.void2.careermanagement.service.GubnService;
import com.void2.careermanagement.type.GroupCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created on 2024-11-30 by 황승현
 * 기업 채용공고 컨트롤러
 */
@Controller
@RequestMapping("/job-post")
public class JopPostController {

    private final GubnService gubnService;

    @Autowired
    public JopPostController(GubnService groupService) {
        this.gubnService = groupService;
    }

    @GetMapping("/register")
    public String regist(Model model) {

        System.out.println(gubnService.getGubnList(GroupCode.SKILL.name()));
        model.addAttribute("skillGubnList", gubnService.getGubnList(GroupCode.SKILL.name()));
        return "jobPost/jobPostRegister";
    }
}
