package com.void2.careermanagement.controller;

import com.void2.careermanagement.dao.ApplyDao;
import com.void2.careermanagement.dao.JobPostDao;
import com.void2.careermanagement.dao.LikeDao;
import com.void2.careermanagement.dao.ScrapDao;
import com.void2.careermanagement.dto.CompanyDto;
import com.void2.careermanagement.dto.GubnDto;
import com.void2.careermanagement.dto.UserDto;
import com.void2.careermanagement.dto.response.JobPostResponseDto;
import com.void2.careermanagement.service.GubnService;
import com.void2.careermanagement.service.JobPostService;
import com.void2.careermanagement.type.GroupCode;
import com.void2.careermanagement.util.SessionUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

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
    private final ApplyDao applyDao;

    @Autowired
    public JobPostController(GubnService groupService, JobPostService jobPostService, LikeDao likeDao, ScrapDao scrapDao, ApplyDao applyDao, JobPostDao jobPostDao) {
        this.gubnService = groupService;
        this.jobPostService = jobPostService;
        this.likeDao = likeDao;
        this.scrapDao = scrapDao;
        this.applyDao = applyDao;
    }

    @GetMapping("/register")
    public String register(Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (SessionUtil.sessionUserCheckRedirectLogin(session, request, response)) return null;
        model.addAttribute("skillGubnList", gubnService.getGubnList(GroupCode.SKILL.name()));
        model.addAttribute("workTypeList", gubnService.getGubnList(GroupCode.WORK_TYPE.name()));
        model.addAttribute("workList", gubnService.getGubnList(GroupCode.WORK.name()));
        model.addAttribute("educationGubnList", gubnService.getGubnList(GroupCode.EDUCATION.name()));
        model.addAttribute("jobRankList", gubnService.getGubnList(GroupCode.JOB_RANK.name()));

        return "jobPost/jobPostRegister";

    }

    @GetMapping("/update/{jobPostNo}")
    public String update(@PathVariable int jobPostNo, Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (SessionUtil.sessionUserCheckRedirectLogin(session, request, response)) return null;

        JobPostResponseDto jobDto = jobPostService.getJobDetail(jobPostNo);

        CompanyDto company = (CompanyDto) session.getAttribute("user");
        if (!(company.getCompanyId().equals(jobDto.getCompanyId()))) return "redirect:/";
        model.addAttribute("jobPostInfo", jobDto);
        model.addAttribute("jobPostSkillCodeList", jobDto.getSkillList().stream()
                .map(GubnDto::getCode)
                .collect(Collectors.toCollection(ArrayList::new)));
        model.addAttribute("skillGubnList", gubnService.getGubnList(GroupCode.SKILL.name()));
        model.addAttribute("workTypeList", gubnService.getGubnList(GroupCode.WORK_TYPE.name()));
        model.addAttribute("workList", gubnService.getGubnList(GroupCode.WORK.name()));
        model.addAttribute("educationGubnList", gubnService.getGubnList(GroupCode.EDUCATION.name()));
        model.addAttribute("jobRankList", gubnService.getGubnList(GroupCode.JOB_RANK.name()));

        return "jobPost/jobPostUpdate";
    }

    @GetMapping("/detail/{jobPostNo}")
    public String jobPost(@PathVariable int jobPostNo, Model model, HttpSession session) {

        JobPostResponseDto jobDto = jobPostService.getJobDetail(jobPostNo);
        model.addAttribute("jobPostInfo", jobDto);

        Object user = session.getAttribute("user");
        if (user == null) {
            model.addAttribute("likeYn", "N");
            model.addAttribute("scrapYn", "N");
            model.addAttribute("applyYn", "N");
        } else {
            String userId = ((UserDto) user).getUserId();
            int likeResult = likeDao.checkLike("user_id", userId, "company_id", jobDto.getCompanyId(), "U");
            int scrapResult = scrapDao.checkScrap(userId, jobPostNo);
            int applyResult = applyDao.checkApply(userId, jobPostNo);
            model.addAttribute("likeYn", likeResult > 0 ? "Y" : "N");
            model.addAttribute("scrapYn", scrapResult > 0 ? "Y" : "N");
            model.addAttribute("applyYn", applyResult > 0 ? "Y" : "N");
        }

        return "jobPost/jobPostDetail";
    }
}
