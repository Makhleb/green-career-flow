package com.void2.careermanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/resume")
public class ResumeController {

    @GetMapping("/create")
    public String create() {
        return "resume/resume-create";
    }
}
