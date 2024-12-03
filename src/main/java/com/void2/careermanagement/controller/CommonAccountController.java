package com.void2.careermanagement.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonAccountController {

    @GetMapping("/account/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        session.removeAttribute("userType");
        return "redirect:/";
    }
}
