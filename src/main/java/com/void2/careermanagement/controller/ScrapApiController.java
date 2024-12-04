package com.void2.careermanagement.controller;

import com.void2.careermanagement.dto.UserDto;
import com.void2.careermanagement.service.ScrapService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2024-12-03 by 황승현
 */
@RestController
@RequestMapping("/api/scrap")
public class ScrapApiController {
    private final ScrapService scrapService;

    public ScrapApiController(ScrapService scrapService) {
        this.scrapService = scrapService;
    }

    @PostMapping("/{jobPostNo}")
    public int insetScrap(@PathVariable("jobPostNo") int jobPostNo, HttpSession session) {
        Object user = session.getAttribute("user");
        if(user == null) return -1;
        return scrapService.insertOrDelete(((UserDto) user).getUserId(), jobPostNo);
    }
}
