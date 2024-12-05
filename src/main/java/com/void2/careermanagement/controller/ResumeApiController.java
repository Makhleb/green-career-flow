package com.void2.careermanagement.controller;

import com.void2.careermanagement.dao.ResumeDao;
import com.void2.careermanagement.dto.UserDto;
import com.void2.careermanagement.dto.request.ResumeFullRequestDto;
import com.void2.careermanagement.dto.request.ResumeRequestDto;
import com.void2.careermanagement.dto.response.ResumeResponseDto;
import com.void2.careermanagement.service.ResumeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created on 2024-12-03 by 황승현
 */
@RestController
@RequestMapping("/api/resume")
public class ResumeApiController {
    private final ResumeService resumeService;
    private final ResumeDao resumeDao;

    public ResumeApiController(ResumeService resumeService, ResumeDao resumeDao) {
        this.resumeService = resumeService;
        this.resumeDao = resumeDao;
    }

    @GetMapping
    public List<ResumeResponseDto> getResume(HttpSession session) {
        Object user = session.getAttribute("user");
        if (user == null) return null;

        UserDto sessionUser = (UserDto) user;
        return resumeService.getValidResumeListByUserId(sessionUser.getUserId());
    }

    @PostMapping("/create")
    public int createResume(@RequestBody ResumeRequestDto resumeRequestDto) {
        return resumeDao.insertResume(resumeRequestDto);
    }

    @PostMapping("/create/full")
    public ResponseEntity<String> createTotalResume(@RequestBody ResumeFullRequestDto resumeFullRequestDto) {
        try {
            resumeService.insertFullResume(resumeFullRequestDto);
            return ResponseEntity.ok("Resume data saved successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving resume data.");
        }
    }
}
