package com.void2.careermanagement.controller;

import com.void2.careermanagement.dao.GubnDao;
import com.void2.careermanagement.type.GroupCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created on 2024-11-30 by 황승현
 * 기업 채용공고 컨트롤러
 */
@Controller
@RequestMapping("/job-post")
public class JopPostController {

    private final GubnDao gubnDao;

    public JopPostController(GubnDao gubnDao) {
        this.gubnDao = gubnDao;
    }

    @GetMapping("/register")
    public String regist(Model model) {

        System.out.println(gubnDao.getGubnList(GroupCode.SKILL.name()));
        model.addAttribute("skillGubnList", gubnDao.getGubnList(GroupCode.SKILL.name()));
        return "jobPost/jobPostRegister";
    }
}
