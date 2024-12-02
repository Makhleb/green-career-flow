package com.void2.careermanagement.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2024-12-01 by 황승현
 */
@RestController
@RequestMapping("/api/job-post")
public class JobPostApiController {
    @PostMapping
    public @ResponseBody int insert() {
        return 1;
    }
}
