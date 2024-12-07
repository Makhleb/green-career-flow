package com.void2.careermanagement.controller;

import com.void2.careermanagement.service.CompanySkillMatchingService;
import com.void2.careermanagement.service.GubnService;
import com.void2.careermanagement.type.GroupCode;
import com.void2.careermanagement.util.SessionUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

/**
 * Created on 2024-12-05 by 안제연
 */

@Controller
@RequestMapping("/skillMatching")
public class CompanySkillMatchingController {
    private final GubnService gubnService;
    private final CompanySkillMatchingService companySkillMatchingService;

    public CompanySkillMatchingController(GubnService gubnService, CompanySkillMatchingService companySkillMatchingService) {
        this.gubnService = gubnService;
        this.companySkillMatchingService = companySkillMatchingService;
    }

    @GetMapping("/company-skill-matching")
    public String companySkillMatching(Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (SessionUtil.sessionUserCheckRedirectLogin(session, request, response)) return null;

        model.addAttribute("skillGubnList", gubnService.getGubnList(GroupCode.SKILL.name()));

        return "/skillMatching/company-skill-matching";
    }
}
