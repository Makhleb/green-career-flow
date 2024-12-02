package com.void2.careermanagement.controller;

import com.void2.careermanagement.dao.UserAccountDao;
import com.void2.careermanagement.dto.UserDto;
import com.void2.careermanagement.dto.UserLoginDto;
import com.void2.careermanagement.service.UserAccountService;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

/**
 * 구직자 계정 관리 API
 */
@RestController
@RequestMapping("/api/user/account")
public class UserAccountApiController {

    private final UserAccountDao userAccountDao;
    private final UserAccountService userAccountService;

    public UserAccountApiController(
            UserAccountDao userAccountDao,
            UserAccountService userAccountService
    ) {
        this.userAccountDao = userAccountDao;
        this.userAccountService = userAccountService;
    }

    @PostMapping("/login")
    public boolean userLogin(@RequestBody UserLoginDto user, HttpSession session) {
        UserDto sessionUser = userAccountDao.loginUserSelect(user.getUserId(), user.getUserPw());
        if (sessionUser != null) {
            session.setAttribute("user", sessionUser);
            return true;
        } else {
            return false;
        }
    }

    @PostMapping("/session-edit")
    public boolean sessionEdit(HttpSession session) {
        UserDto sessionUser = (UserDto) session.getAttribute("user");
        if(sessionUser != null){
            session.setAttribute("user",userAccountDao.sessionSelect(sessionUser.getUserId()));
            return true;
        } else{
            return false;
        }
    }

    @PostMapping("/regist")
    public boolean userRegister(@RequestBody UserDto user) {
        return userAccountDao.userInsert(user) != 0;
    }

    @GetMapping("/check-id/{userId}")
    public int checkId(@PathVariable String userId) {
        return userAccountDao.findUserIdSelect(userId);
    }

    @PutMapping("/update")
    public boolean userUpdate(@RequestBody UserDto user, HttpSession session) {
        return userAccountService.updateUser(user, session);
    }

    @DeleteMapping("/delete/{userId}")
    public boolean userDelete(@PathVariable String userId, HttpSession session) {
        return userAccountService.deleteUser(userId, session);
    }
}
