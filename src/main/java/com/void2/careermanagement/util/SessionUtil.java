package com.void2.careermanagement.util;

import com.void2.careermanagement.dto.CompanyDto;
import com.void2.careermanagement.dto.UserDto;
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
     * @param session  HttpSession 객체
     * @param request  HttpServletRequest 객체
     * @param response HttpServletResponse 객체
     */
    public static boolean sessionUserCheckRedirectLogin(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 로그인 여부 확인
        Object user = session.getAttribute("user");
        if (user == null) {
            // 현재 URL 저장
            String currentUrl = request.getRequestURI() + (request.getQueryString() != null ? "?" + request.getQueryString() : "");
            session.setAttribute("prevPage", currentUrl);

            // 로그인 페이지로 리디렉션
            response.sendRedirect("/user/account/login");
            return true; // 리다이렉션 발생 시 true 반환
        }
        return false; // 로그인된 경우 false 반환
    }

    /**
     * 세션 받아서 user에서 id빼주는 함수!!
     * @param session
     * @return 타입에 맞게 id 반환
     */
    public static String getSessionUserId(HttpSession session) {

        // switch 표현식 사용!!!!φ(゜▽゜*)♪
        return switch (session.getAttribute("user")) {
            case UserDto user -> user.getUserId();
            case CompanyDto company -> company.getCompanyId();
            default -> null; // 기본 값 처리
        };

//        switch (session.getAttribute("user")) {
//            case UserDto user -> {
//                return user.getUserId();
//            }
//            case CompanyDto company -> {
//                return company.getCompanyId();
//            }
//            default -> {
//                return null;
//            }
//        }
    }
}
