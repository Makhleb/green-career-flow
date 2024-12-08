package com.void2.careermanagement.controller;

import com.void2.careermanagement.dao.ResumeDao;
import com.void2.careermanagement.dto.UserDto;
import com.void2.careermanagement.dto.response.ResumeResponseDto;
import com.void2.careermanagement.service.GubnService;
import com.void2.careermanagement.service.ResumeService;
import com.void2.careermanagement.type.ActivityType;
import com.void2.careermanagement.type.GroupCode;
import com.void2.careermanagement.util.SessionUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/resume")
public class ResumeController {

    private final GubnService gubnService;
    private final ResumeService resumeService;
    private final ResumeDao resumeDao;

    public ResumeController(GubnService gubnService, ResumeService resumeService, ResumeDao resumeDao) {
        this.gubnService = gubnService;
        this.resumeService = resumeService;
        this.resumeDao = resumeDao;
    }

    @GetMapping("/create")
    public String create(Model model, HttpSession session) {
        UserDto user = (UserDto)session.getAttribute("user");
        model.addAttribute("activityTypes", ActivityType.values());
        model.addAttribute("skillGubnList", gubnService.getGubnList(GroupCode.SKILL.name()));
        model.addAttribute("workList", gubnService.getGubnList(GroupCode.WORK.name()));
        model.addAttribute("educationList", gubnService.getGubnList(GroupCode.EDUCATION.name()));
        model.addAttribute("militaryList", gubnService.getGubnList(GroupCode.MILITARY.name()));
        model.addAttribute("offered", resumeDao.findByOffer(user.getUserId()));
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
