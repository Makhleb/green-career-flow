package com.void2.careermanagement.controller;

import com.void2.careermanagement.dto.response.CompanyResponseDto;
import com.void2.careermanagement.service.CompanyService;
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

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/detail/{companyId}")
    public String detail(@PathVariable String companyId, Model model) {

        CompanyResponseDto companyInfo = companyService.getCompanyInfoById(companyId);

        model.addAttribute("companyInfo", companyInfo);

        return "company/company-detail";
    }
}
