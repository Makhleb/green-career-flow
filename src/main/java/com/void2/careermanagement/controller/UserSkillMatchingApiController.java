package com.void2.careermanagement.controller;

import com.void2.careermanagement.dto.response.UserSkillMatchingResponseDto;
import com.void2.careermanagement.service.UserSkillMatchingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/select")
    public List<UserSkillMatchingResponseDto> getSkillType(@RequestParam("skillCode") String skillCode) {

        List<UserSkillMatchingResponseDto> list = userSkillMatchingService.getSkillTypePostList(skillCode);
        return list;
    }

}
