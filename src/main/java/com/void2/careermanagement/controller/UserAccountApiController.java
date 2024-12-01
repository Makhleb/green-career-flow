package com.void2.careermanagement.controller;

import com.void2.careermanagement.dao.UserAccountDao;
import com.void2.careermanagement.dto.UserDto;
import com.void2.careermanagement.dto.UserLoginDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/regist")
    public boolean userRegister(@RequestBody UserDto user) {
        return userAccountDao.userInsert(user) != 0;
    }

    @GetMapping("/check-id/{user_id}")
    public int checkId(@PathVariable String user_id) {
        return userAccountDao.findUserIdSelect(user_id);
    }
}
