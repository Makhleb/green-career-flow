package com.void2.careermanagement.service;

import com.void2.careermanagement.dao.MyPageDao;
import com.void2.careermanagement.dto.response.JobPostResponseDto;
import com.void2.careermanagement.dto.response.MyPageScrapDto;
import com.void2.careermanagement.dto.response.ProposalResponseDto;
import com.void2.careermanagement.dto.response.ResumeResponseDto;
import com.void2.careermanagement.type.GroupCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2024-12-04 by 최윤서
 */
@Service
public class MyPageService {
    @Autowired
    private MyPageDao myPageDao;

    public List<ResumeResponseDto> MyPageResumeListById(String userId) {
        return myPageDao.MyPageResumeListById(userId);
    }

    public List<ResumeResponseDto> FullResumeListById(String userId) {
        return myPageDao.FullResumeListById(userId);
    }

    public List<MyPageScrapDto> MyPageScrapListByIdTop3(String userId) {
        return myPageDao.MyPageScrapListByIdTop3(userId);
    }
    public List<ProposalResponseDto> MyPageProposalListByCompanyIdTop3(String CompanyId) {
        return myPageDao.MyPageProposalListByCompanyIdTop3(CompanyId);
    }

    //스크랩한 공고 삭제 -by 안제연
    public void removeUserScrapCompany(int jobPostNo, String userId){myPageDao.deleteScrapCompany(jobPostNo, userId); }

    public List<MyPageScrapDto> MyPageScrapListById(String userId) {
        return myPageDao.MyPageScrapListById(userId);
    }

    public List<JobPostResponseDto> MyPageJobPostListByCompanyIdTop3(String companyId) {
        List<GroupCode> gubnList = new ArrayList<>();

        gubnList.add(GroupCode.WORK_TYPE);
        gubnList.add(GroupCode.WORK);
        gubnList.add(GroupCode.EDUCATION);
        gubnList.add(GroupCode.JOB_RANK);
        return myPageDao.MyPageJobPostListByCompanyIdTop3(companyId, gubnList.stream().map(Enum::name).toList());
    }
}
