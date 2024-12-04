package com.void2.careermanagement.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created on 2024-12-04 by 황승현
 * 세션용 컨트롤러
 */
@RestController
@RequestMapping("/api/session")
public class SessionController {
    @PostMapping("/savePrevPage")
    public String savePrevPage(@RequestBody Map<String, String> data, HttpSession session) {
        String prevPage = data.get("prevPage");
        System.out.println(prevPage);
        if (prevPage != null && !prevPage.isEmpty()) {
            session.setAttribute("prevPage", prevPage); // 세션에 저장
        }
        return "세션 저장 완료!!";
    }
}
