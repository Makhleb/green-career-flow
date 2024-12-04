package com.void2.careermanagement.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Created on 2024-12-04 by 황승현
 * 세선관련 유틸
 */
public class SessionUtil {

    /**
     * 로그인 여부 확인
     *
     * @param session       HttpSession 객체
     * @param request       HttpServletRequest 객체
     * @param response      HttpServletResponse 객체
     */
    public static void sessionUserCheckRedirectLogin(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 로그인 여부 확인
        Object user = session.getAttribute("user");
        if (user == null) {
            // 로그인 이전 URL 저장
            String referer = request.getHeader("Referer");
            if (referer != null) {
                session.setAttribute("prevPage", referer);
            }
            // 로그인 페이지로 리디렉션
            response.sendRedirect("/loginPage");
        }
    }
}
