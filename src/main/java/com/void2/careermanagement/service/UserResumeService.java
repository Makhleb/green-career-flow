package com.void2.careermanagement.service;

import com.void2.careermanagement.dao.UserResumeDao;
import com.void2.careermanagement.dto.response.ApplicantResponseDto;
import com.void2.careermanagement.dto.response.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2024-12-04 by 안제연
 */
@Service
public class UserResumeService {
    @Autowired
    private final UserResumeDao userResumeDao;

    public UserResumeService(UserResumeDao userResumeDao) {
        this.userResumeDao = userResumeDao;
    }

    public List<ApplicantResponseDto> getHighLikeApplicantList() {
        List<ApplicantResponseDto> highLikeList = userResumeDao.getHighLikeUserList();
        for (int i = 0; i < highLikeList.size(); i++) {
            highLikeList.get(i).setSkillList(userResumeDao.getSkillListByResumeNo(highLikeList.get(i).getResumeNo()));
        }
        return highLikeList;
    }

    public List<UserResponseDto> getUserResumeListByApplyId(String companyId) {
        List<UserResponseDto> userResumeList = userResumeDao.getApplyListByCompanyId(companyId);
        for (int i = 0; i < userResumeList.size(); i++) {
            userResumeList.get(i).setSkillList(userResumeDao.getSkillListByResumeNo(userResumeList.get(i).getResumeNo()));
        }
        return userResumeList;
    }
}
