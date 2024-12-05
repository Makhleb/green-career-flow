package com.void2.careermanagement.controller;

import com.void2.careermanagement.dto.UserDto;
import com.void2.careermanagement.dto.response.MyPageScrapDto;
import com.void2.careermanagement.service.MyPageService;
import com.void2.careermanagement.util.SessionUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

/**
 * Created on 2024-12-05 by 안제연
 */

@Controller
@RequestMapping("/mypage")
public class UserScrapController {

    private final MyPageService myPageService;

    public UserScrapController(MyPageService myPageService) {
        this.myPageService = myPageService;
    }

    @GetMapping("/user-scrap-company")
    public String userScrapCompany(Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(SessionUtil.sessionUserCheckRedirectLogin(session, request, response)) return null;
        String isEmpty = "Empty";
        UserDto sessionUser = (UserDto) session.getAttribute("user");
        //나의 스크랩 보기
        List<MyPageScrapDto> scrapList = myPageService.MyPageScrapListById(sessionUser.getUserId());
        if(!scrapList.isEmpty()) {
            for(MyPageScrapDto s:scrapList)  System.out.println(s);

            isEmpty = "notEmpty";
        }
        model.addAttribute("scrapList", scrapList);
        model.addAttribute("isEmpty", isEmpty);

        return "/mypage/user-scrap-company";
    }

    @GetMapping("/delete-scrap-company")
    public String deleteScrapCompany(@RequestParam("jobPostNo") int jobPostNo, HttpSession session) {
        UserDto sessionUser = (UserDto) session.getAttribute("user");
        myPageService.removeUserScrapCompany(jobPostNo, sessionUser.getUserId());
        return "redirect:/mypage/user-scrap-company";
    }
}
