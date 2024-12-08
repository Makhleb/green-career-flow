package com.void2.careermanagement.service;

import com.void2.careermanagement.dao.UserResumeDao;
import com.void2.careermanagement.dto.response.ApplicantResponseDto;
import com.void2.careermanagement.dto.response.UserResponseDto;
import com.void2.careermanagement.util.ImageUtil;
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
        return setImageEncodeBase64(highLikeList);
    }

    public List<UserResponseDto> getUserResumeListByApplyIdTop3(String companyId) {
        List<UserResponseDto> userResumeListTop3 = userResumeDao.getApplyListByCompanyIdTop3(companyId);
        for (int i = 0; i < userResumeListTop3.size(); i++) {
            userResumeListTop3.get(i).setSkillList(userResumeDao.getSkillListByResumeNo(userResumeListTop3.get(i).getResumeNo()));
        }
        return userResumeListTop3;
    }

    public List<UserResponseDto> getUserResumeListByApplyId(String companyId) {
        List<UserResponseDto> userResumeList = userResumeDao.getApplyListByCompanyId(companyId);
        for (int i = 0; i < userResumeList.size(); i++) {
            userResumeList.get(i).setSkillList(userResumeDao.getSkillListByResumeNo(userResumeList.get(i).getResumeNo()));
        }
        return userResumeList;
    }

    public List<ApplicantResponseDto> setImageEncodeBase64(List<ApplicantResponseDto> highLikeList) {
        for(ApplicantResponseDto dto : highLikeList) {
            dto.setCompanyImageBase64(ImageUtil.encodeToBase64(dto.getCompanyImage()));
        }
        return highLikeList;
    }
}
