package com.void2.careermanagement.controller;

import com.void2.careermanagement.dto.UserDto;
import com.void2.careermanagement.dto.response.MyPageScrapDto;
import com.void2.careermanagement.dto.response.ResumeResponseDto;
import com.void2.careermanagement.service.MyPageService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created on 2024-12-04 by 최윤서
 */
@Controller
@RequestMapping("/mypage")
public class MyPageController {

    @Autowired
    private MyPageService myPageService;

    @RequestMapping("/profile")
    public String profile(HttpSession session, Model model) {
        UserDto user = (UserDto) session.getAttribute("user");
        String userId = user.getUserId(); // UserDto 객체의 userId 필드 접근
        List<ResumeResponseDto> resumeList = myPageService.MyPageResumeListById(userId);
        List<MyPageScrapDto> scrapList = myPageService.MyPageScrapListById(userId);
        model.addAttribute("resumeList", resumeList);
        model.addAttribute("scrapList", scrapList);
        return "/mypage/user-mypage";
    }

    @RequestMapping("/proposal")
    public String proposal() {
        return "/mypage/user-proposal";
    }

}
