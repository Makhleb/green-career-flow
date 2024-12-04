package com.void2.careermanagement.controller;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

/**
 * 구직자 계정 관리 페이지 이동용 컨트롤러
 */
@Controller
@RequestMapping("/user/account")
public class UserAccountController {

    @GetMapping("/login")
    public String userLogin(HttpSession session, HttpServletResponse response) throws IOException {
        String prevPage = (String) session.getAttribute("prevPage");
        if (prevPage != null) {
            session.removeAttribute("prevPage"); // 세션에서 제거
            response.sendRedirect(prevPage);
        }
        return "account/user-login";
    }

    @GetMapping("/regist")
    public String userRegist() {
        return "account/user-regist";
    }

    @GetMapping("/update")
    public String userUpdate() {
        return "account/user-update";
    }
}
