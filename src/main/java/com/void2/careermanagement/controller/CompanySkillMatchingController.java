package com.void2.careermanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created on 2024-12-05 by 안제연
 */

@Controller
@RequestMapping("/skillMatching")
public class CompanySkillMatchingController {
    @GetMapping("/company-skill-matching")
    public String companySkillMatching() {
        System.out.println("companySkillMatching..");
        return "/skillMatching/company-skill-matching";
    }
}
