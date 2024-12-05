package com.void2.careermanagement.controller;

import com.void2.careermanagement.dto.UserDto;
import com.void2.careermanagement.dto.response.UserInterestCompanyDto;
import com.void2.careermanagement.service.UserInterestCompanyService;
import com.void2.careermanagement.util.SessionUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
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
    public String userInterestCompany(Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(SessionUtil.sessionUserCheckRedirectLogin(session, request, response)) return null;
        String isEmpty = "Empty";
        System.out.println("user-interest-company...");
        UserDto sessionUser = (UserDto)session.getAttribute("user");
        List<UserInterestCompanyDto> uiList = userInterestCompanyService.getUserInterestCompanyList(sessionUser.getUserId());
        if(!uiList.isEmpty()) {
            //for(UserInterestCompanyDto ui : uiList) System.out.println(ui);
            isEmpty="notEmpty";
        }
        model.addAttribute("isEmpty", isEmpty);
        model.addAttribute("uiList", uiList);
        return "/mypage/user-interest-company";
    }

    @GetMapping("/delete-interest-company")
    public String deleteInterestCompany(@RequestParam("companyId") String companyId, Model model, HttpSession session) {
        System.out.println(companyId);
        userInterestCompanyService.removeUserInterestCompany(companyId);
        return "redirect:/mypage/user-interest-company";
    }
}
