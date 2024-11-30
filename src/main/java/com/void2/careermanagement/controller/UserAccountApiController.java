package com.void2.careermanagement.controller;

import com.void2.careermanagement.dao.UserAccountDao;
import com.void2.careermanagement.dto.UserLoginDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 구직자 계정 관리 API
 */
@RestController
@RequestMapping("/api/user/account")
public class UserAccountApiController {

    private final UserAccountDao userAccountDao;

    public UserAccountApiController(UserAccountDao userAccountDao) {
        this.userAccountDao = userAccountDao;
    }

    @PostMapping("/login")
    public boolean userLogin(@RequestBody UserLoginDto user, HttpSession session) {
        if(userAccountDao.loginUserSelect(user.getUser_id(), user.getUser_pw()) != null){
            session.setAttribute("user", user);
            return true;
        } else{
            return false;
        }
    }
}
