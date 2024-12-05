package com.void2.careermanagement.controller;

import com.void2.careermanagement.service.GubnService;
import com.void2.careermanagement.type.GroupCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/resume")
public class ResumeController {

    private final GubnService gubnService;

    public ResumeController(GubnService gubnService) {
        this.gubnService = gubnService;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("skillGubnList", gubnService.getGubnList(GroupCode.SKILL.name()));
        model.addAttribute("workList", gubnService.getGubnList(GroupCode.WORK.name()));
        model.addAttribute("educationList", gubnService.getGubnList(GroupCode.EDUCATION.name()));
        model.addAttribute("militaryList", gubnService.getGubnList(GroupCode.MILITARY.name()));
        return "resume/resume-create";
    }
}
