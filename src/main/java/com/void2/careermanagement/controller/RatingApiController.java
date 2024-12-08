package com.void2.careermanagement.controller;

import com.void2.careermanagement.service.RatingService;
import com.void2.careermanagement.util.SessionUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2024-12-08 by 황승현
 */
@RestController
@RequestMapping("/api/rating")
public class RatingApiController {
    private final RatingService ratingService;

    public RatingApiController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping
    public int insert(@RequestParam("companyId") String companyId, @RequestParam("score") int score, HttpSession session) {
        if(session.getAttribute("user") == null) return -1;
        return ratingService.insert(companyId, score, SessionUtil.getSessionUserId(session));
    }
}
