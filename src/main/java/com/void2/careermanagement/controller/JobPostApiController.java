package com.void2.careermanagement.controller;

import com.void2.careermanagement.dto.request.JobPostRequestDto;
import com.void2.careermanagement.service.JobPostService;
import org.springframework.web.bind.annotation.*;

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
    public int insert(@RequestBody JobPostRequestDto jopPostRequestDto) {
//        System.out.println(jopPostRequestDto);
        return jobPostService.jobPostInsert(jopPostRequestDto);
    }
    @PutMapping
    public int update(@RequestBody JobPostRequestDto jopPostRequestDto) {
        return jobPostService.jobPostUpdate(jopPostRequestDto);
    }
    @DeleteMapping("/{jopPostNo}")
    public int delete(@PathVariable("jopPostNo") int jopPostNo) {
        return jobPostService.jobPostDelete(jopPostNo);
    }
}
