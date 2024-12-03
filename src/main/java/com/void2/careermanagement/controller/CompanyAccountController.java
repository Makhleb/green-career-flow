package com.void2.careermanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("company/account")
public class CompanyAccountController {

    @GetMapping("/update")
    public String companyAccount() {
        return "account/company-update";
    }
}
