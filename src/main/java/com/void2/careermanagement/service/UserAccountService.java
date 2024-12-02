package com.void2.careermanagement.service;

import com.void2.careermanagement.dao.UserAccountDao;
import com.void2.careermanagement.dto.UserDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {

    private final UserAccountDao userAccountDao;

    @Autowired
    public UserAccountService(UserAccountDao userAccountDao) {
        this.userAccountDao = userAccountDao;
    }

    /**
     * 사용자 정보 업데이트
     * 세션이 존재하지 않을시 false 반환
     *
     * @return 업데이트 성공 여부
     */
    public boolean updateUser(UserDto user, HttpSession session) {
        UserDto userSession = (UserDto) session.getAttribute("user");
        if (userSession == null) {
            return false;
        }
        if (!userSession.getUserId().equals(user.getUserId())) {
            return false;
        }
        return userAccountDao.userUpdate(user) != 0;
    }

    /**
     * 사용자 삭제
     * 세션이 존재하지 않을시 false 반환
     * @return 업데이트 성공 여부
     */
    public boolean deleteUser(String userId, HttpSession session) {

        UserDto userSession = (UserDto) session.getAttribute("user");
        if (userSession == null) {
            return false;
        }
        if (!userSession.getUserId().equals(userId)) {
            return false;
        }
        if (userAccountDao.userDelete(userId) != 0) {
            session.removeAttribute("user");
            return true;
        }
        return false;
    }
}

