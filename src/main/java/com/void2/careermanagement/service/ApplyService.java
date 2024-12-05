package com.void2.careermanagement.service;

import com.void2.careermanagement.dao.ApplyDao;
import com.void2.careermanagement.dao.UserResumeDao;
import com.void2.careermanagement.dto.request.ApplyRequestDto;
import com.void2.careermanagement.dto.response.ApplyResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2024-12-04 by 황승현
 */
@Service
public class ApplyService {
    private final ApplyDao applyDao;
    private final UserResumeDao userResumeDao;

    public ApplyService(ApplyDao applyDao, UserResumeDao userResumeDao) {
        this.applyDao = applyDao;
        this.userResumeDao = userResumeDao;
    }

    public int insert(ApplyRequestDto applyDto) {
        try {
            applyDao.insert(applyDto);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List<ApplyResponseDto> getApplyListByJobPostNo(int jobPostNo) {
        List<ApplyResponseDto> applyList = applyDao.getApplyListByJobPostNo(jobPostNo);

        for (int i = 0; i < applyList.size(); i++) {
            applyList.get(i).setSkillList(userResumeDao.getSkillListByResumeNo(applyList.get(i).getResumeNo()));
        }
        return applyList;
    }

    public int updatePass(ApplyRequestDto applyDto) {
        try {
            applyDao.updatePass(applyDto);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
