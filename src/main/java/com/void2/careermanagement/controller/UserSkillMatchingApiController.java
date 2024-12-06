package com.void2.careermanagement.controller;

import com.void2.careermanagement.service.UserSkillMatchingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2024-12-05 by 최윤서
 */
@RestController
@RequestMapping("/api/skillMatching")
public class UserSkillMatchingApiController {

    private final UserSkillMatchingService userSkillMatchingService;

    public UserSkillMatchingApiController(UserSkillMatchingService userSkillMatchingService) {
        this.userSkillMatchingService = userSkillMatchingService;
    }

}
