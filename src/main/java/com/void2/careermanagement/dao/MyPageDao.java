package com.void2.careermanagement.dao;

import com.void2.careermanagement.dto.response.MyPageScrapDto;
import com.void2.careermanagement.dto.response.ProposalResponseDto;
import com.void2.careermanagement.dto.response.ResumeResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created on 2024-12-04 by 최윤서
 */
@Mapper
public interface MyPageDao {

    public List<ResumeResponseDto> MyPageResumeListById(String userId);
    public List<MyPageScrapDto> MyPageScrapListByIdTop3(String userId);

    public List<ProposalResponseDto> MyPageProposalListByCompanyIdTop3(String CompanyId);
    int getCountScrapByUserId(String userId);
    int getCountProposalByCompanyId(String userId);

    //스크랩한 공고 삭제 -by 안제연
    public void deleteScrapCompany(int jobPostNo);
}
