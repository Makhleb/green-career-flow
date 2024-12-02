package com.void2.careermanagement.controller;

import com.void2.careermanagement.dto.request.JopPostRequestDto;
import com.void2.careermanagement.dto.request.SkillRequestDto;
import com.void2.careermanagement.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created on 2024-12-01 by 황승현
 */
@RestController
@RequestMapping("/api/job-post")
public class JobPostApiController {
    private final JobPostService jobPostService;

    public JobPostApiController(JobPostService jobPostService) {
        this.jobPostService = jobPostService;
    }

    @PostMapping
    public @ResponseBody int insert(@RequestBody JopPostRequestDto jopPostRequestDto) {
//        System.out.println(jopPostRequestDto);
        return jobPostService.jobPostInsert(jopPostRequestDto);
    }
}
