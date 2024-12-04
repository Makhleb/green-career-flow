package com.void2.careermanagement.service;

import com.void2.careermanagement.dao.ApplyDao2;
import com.void2.careermanagement.dto.response.UserResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2024-12-04 by 안제연
 */
@Service
public class UserResumeService {

    private final ApplyDao2 applyDao2;

    public UserResumeService(ApplyDao2 applyDao2) {
        this.applyDao2 = applyDao2;
    }

    public List<UserResponseDto> getUserReumeList() {
//        List<UserResponseDto> userResponseDtos = applyDao2.getApplyListByCompanyId();
//        return new ArrayList<>(userResponseDtos);
        return null;
    }
    public List<UserResponseDto> getUserResumeListByApplyId(String companyId) {
        List<UserResponseDto> userResumeList = applyDao2.getApplyListByCompanyId(companyId);
        for (int i = 0; i < userResumeList.size(); i++) {
            userResumeList.get(i).setSkillList(applyDao2.getSkillListByResumeNo(userResumeList.get(i).getResumeNo()));
        }
        return userResumeList;
    }
}
