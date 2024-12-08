package com.void2.careermanagement.controller;

import com.void2.careermanagement.dto.response.CompanyResponseDto;
import com.void2.careermanagement.service.CompanyService;
import com.void2.careermanagement.service.RatingService;
import com.void2.careermanagement.util.SessionUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created on 2024-12-06 by 황승현
 */
@Controller
@RequestMapping("/company")
public class CompanyController {
    private final CompanyService companyService;
    private final RatingService ratingService;

    public CompanyController(CompanyService companyService, RatingService ratingService) {
        this.companyService = companyService;
        this.ratingService = ratingService;
    }

    @GetMapping("/detail/{companyId}")
    public String detail(@PathVariable String companyId, Model model, HttpSession session) {

        CompanyResponseDto companyInfo = companyService.getCompanyInfoById(companyId);

        model.addAttribute("companyInfo", companyInfo);
        model.addAttribute("companyId", companyId);

        if (session.getAttribute("user") != null && session.getAttribute("userType").toString().equals("U")) {
            model.addAttribute("userRating", ratingService.getUserRating(companyId, SessionUtil.getSessionUserId(session)));
        }

        return "company/company-detail";
    }
}
