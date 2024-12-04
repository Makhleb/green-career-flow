package com.void2.careermanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created on 2024-12-04 by 최윤서
 */
@Controller
@RequestMapping("/mypage")
public class MyPageController {

    @RequestMapping("/profile")
    public String profile() {
        return "/mypage/user-mypage";
    }
}
