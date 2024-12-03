package com.void2.careermanagement.controller;

import com.void2.careermanagement.dto.UserDto;
import com.void2.careermanagement.dto.response.ResumeResponseDto;
import com.void2.careermanagement.service.ResumeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2024-12-03 by 황승현
 */
@RestController
@RequestMapping("/api/resume")
public class ResumeApiController {
    private final ResumeService resumeService;

    public ResumeApiController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @GetMapping
    public List<ResumeResponseDto> getResume(HttpSession session) {
        Object user = session.getAttribute("user");
        if(user == null) return null;

        UserDto sessionUser = (UserDto) user;
        List<ResumeResponseDto> resumeList = resumeService.getListByUserId(sessionUser.getUserId());
        return resumeList;
    }

}
