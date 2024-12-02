package com.void2.careermanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 구직자 계정 관리 페이지 이동용 컨트롤러
 */
@Controller
@RequestMapping("/user/account")
public class UserAccountController {

    @GetMapping("/login")
    public String userLogin() {
        return "user/user-login";
    }
    @GetMapping("/regist")
    public String userRegist() {
        return "user/user-regist";
    }
    @GetMapping("/update")
    public String userUpdate() {
        return "user/user-update";
    }
}
