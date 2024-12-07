package com.void2.careermanagement.controller;

import com.void2.careermanagement.service.GubnService;
import com.void2.careermanagement.service.ResumeService;
import com.void2.careermanagement.type.ActivityType;
import com.void2.careermanagement.type.GroupCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/resume")
public class ResumeController {

    private final GubnService gubnService;
    private final ResumeService resumeService;

    public ResumeController(GubnService gubnService, ResumeService resumeService) {
        this.gubnService = gubnService;
        this.resumeService = resumeService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        return "resume/resume-list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("activityTypes", ActivityType.values());
        model.addAttribute("skillGubnList", gubnService.getGubnList(GroupCode.SKILL.name()));
        model.addAttribute("workList", gubnService.getGubnList(GroupCode.WORK.name()));
        model.addAttribute("educationList", gubnService.getGubnList(GroupCode.EDUCATION.name()));
        model.addAttribute("militaryList", gubnService.getGubnList(GroupCode.MILITARY.name()));
        return "resume/resume-create";
    }

    // todo 다른 회원이 접근못하도록 방어코드 제작바람
    // todo 생일을 이용하여 만나이 계산하기
    @GetMapping("/detail/{resumeNo}")
    public String detail(Model model, @PathVariable("resumeNo") int resumeNo) {
        model.addAttribute("totalResume",resumeService.getTotalResume(resumeNo));

        return "resume/resume-detail";
    }
}
