package com.void2.careermanagement.controller;


import com.void2.careermanagement.dao.SampleDao;
import com.void2.careermanagement.dto.CompanyDto;
import com.void2.careermanagement.dto.UserDto;
import com.void2.careermanagement.service.CompanyService;
import com.void2.careermanagement.service.GubnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SampleController {

    private final CompanyService companyService;
    @Autowired
    public SampleController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping("/")
    public String root(Model model){
        System.out.println("main");
        List<CompanyDto> cList = companyService.getHighRatingCompanyList();
        for(CompanyDto c : cList) System.out.println(c);
        model.addAttribute("cList", cList);
        return "main";
    }
}
