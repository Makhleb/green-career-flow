package com.void2.careermanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created on 2024-11-30 by 황승현
 * 기업 채용공고 컨트롤러
 */
@Controller
@RequestMapping("/job-post")
public class JopPostController {
    @RequestMapping("/register")
    public String regist() {
        return "jobPost/jobPostRegister";
    }
}
