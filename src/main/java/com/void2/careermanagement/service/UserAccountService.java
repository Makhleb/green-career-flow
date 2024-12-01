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
     * @return 업데이트 성공 여부
     */
    public boolean updateUser(UserDto user, HttpSession session) {
        if (session.getAttribute("user") != null) {
            UserDto userSession = (UserDto) session.getAttribute("user");
            String session_id = userSession.getUserId();
            if (session_id.equals(user.getUserId())) {
                return userAccountDao.userUpdate(user) != 0;
            }
        }
        return false;
    }

    /**
     * 사용자 삭제
     * 세션이 존재하지 않을시 false 반환
     *  @return 업데이트 성공 여부
     */
    public boolean deleteUser(String userId, HttpSession session) {
        if (session.getAttribute("user") != null) {
            UserDto userSession = (UserDto) session.getAttribute("user");
            String session_id = userSession.getUserId();
            if (session_id.equals(userId)) {
                if(userAccountDao.userDelete(userId) != 0){
                    session.removeAttribute("user");
                    return true;
                }
            }
        }
//        UserDto userSession = (UserDto) session.getAttribute("user");
//        if (userSession != null && userSession.getUserId().equals(userId)) {
//
//            String session_id = userSession.getUserId();
//            if (session_id.equals(userId)) {
//                if(userAccountDao.userDelete(userId) != 0){
//                    session.removeAttribute("user");
//                    return true;
//                }
//            }
//        }
        return false;
    }
}

