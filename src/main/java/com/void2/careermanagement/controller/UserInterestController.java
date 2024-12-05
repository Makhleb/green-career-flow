package com.void2.careermanagement.controller;

import com.void2.careermanagement.dto.UserDto;
import com.void2.careermanagement.dto.response.UserInterestCompanyDto;
import com.void2.careermanagement.service.UserInterestCompanyService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created on 2024-12-04 by 안제연
 */
@Controller
@RequestMapping("/mypage")
public class UserInterestController {
    private final UserInterestCompanyService userInterestCompanyService;

    @Autowired
    public UserInterestController(UserInterestCompanyService userInterestCompanyService) {
        this.userInterestCompanyService = userInterestCompanyService;
    }
    @GetMapping("/user-interest-company")
    public String userInterestCompany(Model model, HttpSession session) {
        System.out.println("user-interest-company...");
        UserDto sessionUser = (UserDto)session.getAttribute("user");
        List<UserInterestCompanyDto> uiList = userInterestCompanyService.getUserInterestCompanyList(sessionUser.getUserId());
        for(UserInterestCompanyDto ui : uiList) {
            System.out.println(ui);
        }
        model.addAttribute("uiList", uiList);
        return "/mypage/user-interest-company";
    }
}
