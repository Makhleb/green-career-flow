package com.void2.careermanagement.controller;

import com.void2.careermanagement.dao.ApplyDao;
import com.void2.careermanagement.dto.CompanyDto;
import com.void2.careermanagement.dto.UserDto;
import com.void2.careermanagement.dto.response.ApplyResponseDto;
import com.void2.careermanagement.dto.response.JobPostResponseDto;
import com.void2.careermanagement.dto.response.MyPageScrapDto;
import com.void2.careermanagement.dto.response.ProposalResponseDto;
import com.void2.careermanagement.dto.response.ResumeResponseDto;
import com.void2.careermanagement.service.ApplyService;
import com.void2.careermanagement.service.JobPostService;
import com.void2.careermanagement.service.MyPageService;
import com.void2.careermanagement.util.SessionUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

/**
 * Created on 2024-12-04 by 최윤서
 */
@Controller
@RequestMapping("/mypage")
public class MyPageController {

    private final MyPageService myPageService;
    private final ApplyDao applyDao;
    private JobPostService jobPostService;
    private ApplyService applyService;

    @Autowired
    public MyPageController(MyPageService myPageService, ApplyDao applyDao, JobPostService jobPostService, ApplyService applyService) {
        this.myPageService = myPageService;
        this.applyDao = applyDao;
        this.jobPostService = jobPostService;
        this.applyService = applyService;
    }


    public MyPageController(MyPageService myPageService, ApplyDao applyDao) {
        this.myPageService = myPageService;
        this.applyDao = applyDao;
    }

    @GetMapping("/profile")
    public String profile(HttpSession session, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (SessionUtil.sessionUserCheckRedirectLogin(session, request, response)) return null;
        String userType = session.getAttribute("userType").toString();
        String returnUrl = "";
        Object sessionUser = session.getAttribute("user");
        if (userType.equals("U")) {
            UserDto user = (UserDto) sessionUser;
            String userId = user.getUserId(); // UserDto 객체의 userId 필드 접근
            List<ResumeResponseDto> resumeList = myPageService.MyPageResumeListById(userId);
            List<MyPageScrapDto> scrapList = myPageService.MyPageScrapListById(userId);
            model.addAttribute("resumeList", resumeList);
            model.addAttribute("scrapList", scrapList);
            returnUrl = "/mypage/user-mypage";
        } else if (userType.equals("C")) {
            CompanyDto user = (CompanyDto) sessionUser;
            String companyId = user.getCompanyId();
            List<ProposalResponseDto> proposalList = myPageService.MyPageProposalListByCompanyId(companyId);
            model.addAttribute("plist", proposalList);
            returnUrl = "/mypage/company-mypage";
        }
        return returnUrl;
    }


    @GetMapping("/apply")
    public String apply(HttpSession session, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {

        if (SessionUtil.sessionUserCheckRedirectLogin(session, request, response)) return null;

        String userType = session.getAttribute("userType").toString();
        String returnPage = "";
        Object sessionUser = session.getAttribute("user");

        if (userType.equals("U")) {
            UserDto user = (UserDto) session.getAttribute("user");
            String userId = user.getUserId();

            List<ApplyResponseDto> applyList = applyDao.getApplyListByUserId(userId);

            model.addAttribute("applyList", applyList);
            returnPage = "/mypage/user-apply";
        } else if (userType.equals("C")) {
//
//            CompanyDto user = (CompanyDto) sessionUser;
//            String companyId = user.getCompanyId();
//            List<JobPostResponseDto> jobPostList = jobPostService.getJobPostListByCompanyId(companyId);
//            System.out.println(jobPostList);
//            model.addAttribute("jobPostList", jobPostList);
//            returnPage = "/mypage/company-apply";
        }
        return returnPage;
    }

    @GetMapping("/apply/{jobPostNo}")
    public String apply(@PathVariable int jobPostNo, HttpSession session, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (SessionUtil.sessionUserCheckRedirectLogin(session, request, response)) return null;
        String userType = session.getAttribute("userType").toString();
        String returnPage = "";
        Object sessionUser = session.getAttribute("user");

        if (userType.equals("C")) {
            CompanyDto user = (CompanyDto) sessionUser;
            String companyId = user.getCompanyId();
            List<ApplyResponseDto> applyList = applyService.getApplyListByJobPostNo(jobPostNo);
            System.out.println(applyList);
            model.addAttribute("applyList", applyList);
            returnPage = "/mypage/company-apply";
        }
        return returnPage;
    }

    @GetMapping("/job-post")
    public String jobPost(HttpSession session, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (SessionUtil.sessionUserCheckRedirectLogin(session, request, response)) return null;

        String userType = session.getAttribute("userType").toString();
        String returnPage = "";
        Object sessionUser = session.getAttribute("user");

        if (userType.equals("U")) {

            returnPage = "/mypage/user-mypage";

        } else if (userType.equals("C")) {

            CompanyDto user = (CompanyDto) sessionUser;
            String companyId = user.getCompanyId();
            List<JobPostResponseDto> jobPostList = jobPostService.getJobPostListByCompanyId(companyId);
            System.out.println(jobPostList);
            model.addAttribute("jobPostList", jobPostList);
            returnPage = "/mypage/company-job-post";

        }
        return returnPage;
    }

}
