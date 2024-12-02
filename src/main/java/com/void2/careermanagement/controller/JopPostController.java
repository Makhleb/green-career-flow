package com.void2.careermanagement.controller;

import com.void2.careermanagement.dao.JobPostDao;
import com.void2.careermanagement.dto.response.JobPostResponseDto;
import com.void2.careermanagement.service.GubnService;
import com.void2.careermanagement.service.JobPostService;
import com.void2.careermanagement.type.GroupCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created on 2024-11-30 by 황승현
 * 기업 채용공고 컨트롤러
 */
@Controller
@RequestMapping("/job-post")
@Slf4j
public class JopPostController {

    private final GubnService gubnService;
    private final JobPostService jobPostService;

    @Autowired
    public JopPostController(GubnService groupService, JobPostService jobPostService) {
        this.gubnService = groupService;
        this.jobPostService = jobPostService;
    }

    @GetMapping("/register")
    public String register(Model model) {

        model.addAttribute("skillGubnList", gubnService.getGubnList(GroupCode.SKILL.name()));
        model.addAttribute("workTypeList", gubnService.getGubnList(GroupCode.WORK_TYPE.name()));
        model.addAttribute("workList", gubnService.getGubnList(GroupCode.WORK.name()));
        model.addAttribute("educationGubnList", gubnService.getGubnList(GroupCode.EDUCATION.name()));
        model.addAttribute("jobRankList", gubnService.getGubnList(GroupCode.JOB_RANK.name()));

        return "jobPost/jobPostRegister";
    }
    @GetMapping("/{jobPostNo}")
    public String jobPost(@PathVariable int jobPostNo, Model model) {
        model.addAttribute("jobPostInfo", jobPostService.getJobDetail(jobPostNo));
        return "jobPost/jobPostDetail";
    }
}
