package com.void2.careermanagement.controller;

import com.void2.careermanagement.response.CompanyResponseDto;
import com.void2.careermanagement.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created on 2024-12-02 by 안제연
 */

@Controller
public class MainController {
    private final CompanyService companyService;
    @Autowired
    public MainController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping("/")
    public String root(Model model){
        System.out.println("main");

        //평점 높은 회사 리스트
        List<CompanyResponseDto> cList = companyService.getHighRatingCompanyList();
        for(CompanyResponseDto c : cList) System.out.println(c);
        //채용임박 공고 리스트
        List<CompanyResponseDto> eList = companyService.getFastDeadLineList();
        for(CompanyResponseDto e : eList) System.out.println(e);
        model.addAttribute("cList", cList);
        model.addAttribute("eList", eList);
        return "main";
    }
}
