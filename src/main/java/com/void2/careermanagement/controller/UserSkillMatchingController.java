package com.void2.careermanagement.controller;

import com.void2.careermanagement.service.GubnService;
import com.void2.careermanagement.type.GroupCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created on 2024-12-05 by 최윤서
 */
@Controller
@RequestMapping("/skillMatching")
public class UserSkillMatchingController {

    private final GubnService gubnService;

    public UserSkillMatchingController(GubnService gubnService) {
        this.gubnService = gubnService;
    }

    @RequestMapping("/user-skill-matching")
    public String skillMatching(Model model) {
        model.addAttribute("skillGubnList", gubnService.getGubnList(GroupCode.SKILL.name()));
        model.addAttribute("workTypeList", gubnService.getGubnList(GroupCode.WORK_TYPE.name()));
        return "/skillMatching/user-skill-matching";
    }

}
