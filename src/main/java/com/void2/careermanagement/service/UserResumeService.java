package com.void2.careermanagement.service;

import com.void2.careermanagement.dao.UserResumeDao;
import com.void2.careermanagement.dto.response.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2024-12-03 by 안제연
 */
@Service
public class UserResumeService {

    private final UserResumeDao userResumeDao;
    @Autowired
    public UserResumeService(UserResumeDao userResumeDao) {this.userResumeDao = userResumeDao;}

    public List<UserResponseDto> getUserReumeList(){
        List<UserResponseDto> list = userResumeDao.getHighLikeUserList();
        for(UserResponseDto user : list){
            System.out.println(user + "service");
        }
        return userResumeDao.getHighLikeUserList();
    }

}
