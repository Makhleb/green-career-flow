package com.void2.careermanagement.controller;

import com.void2.careermanagement.dao.LikeDao;
import com.void2.careermanagement.dao.ScrapDao;
import com.void2.careermanagement.dto.UserDto;
import com.void2.careermanagement.dto.response.JobPostResponseDto;
import com.void2.careermanagement.service.GubnService;
import com.void2.careermanagement.service.JobPostService;
import com.void2.careermanagement.type.GroupCode;
import jakarta.servlet.http.HttpSession;
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
public class JobPostController {

    private final GubnService gubnService;
    private final JobPostService jobPostService;
    private final LikeDao likeDao;
    private final ScrapDao scrapDao;

    @Autowired
    public JobPostController(GubnService groupService, JobPostService jobPostService, LikeDao likeDao, ScrapDao scrapDao) {
        this.gubnService = groupService;
        this.jobPostService = jobPostService;
        this.likeDao = likeDao;
        this.scrapDao = scrapDao;
    }

    @GetMapping("/register")
    public String register(Model model, HttpSession session) {
        if(session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        model.addAttribute("skillGubnList", gubnService.getGubnList(GroupCode.SKILL.name()));
        model.addAttribute("workTypeList", gubnService.getGubnList(GroupCode.WORK_TYPE.name()));
        model.addAttribute("workList", gubnService.getGubnList(GroupCode.WORK.name()));
        model.addAttribute("educationGubnList", gubnService.getGubnList(GroupCode.EDUCATION.name()));
        model.addAttribute("jobRankList", gubnService.getGubnList(GroupCode.JOB_RANK.name()));

        return "jobPost/jobPostRegister";
    }
    @GetMapping("/detail/{jobPostNo}")
    public String jobPost(@PathVariable int jobPostNo, Model model, HttpSession session) {

        JobPostResponseDto jobDto = jobPostService.getJobDetail(jobPostNo);
        model.addAttribute("jobPostInfo", jobDto);

        Object user = session.getAttribute("user");
        if(user == null) {
            model.addAttribute("likeYn", "N");
            model.addAttribute("scrapYn", "N");
        } else {
            String userId = ((UserDto) user).getUserId();
            int likeResult = likeDao.checkLike("user_id", userId, "company_id", jobDto.getCompanyId(), "U");
            int scrapResult = scrapDao.checkScrap(userId, jobPostNo);
            model.addAttribute("likeYn", likeResult > 0 ? "Y" : "N");
            model.addAttribute("scrapYn", scrapResult > 0 ? "Y" : "N");
        }

        return "jobPost/jobPostDetail";
    }
}
