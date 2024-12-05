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
    public List<MyPageScrapDto> MyPageScrapListById(String userId);

    public List<ProposalResponseDto> MyPageProposalListByCompanyId(String CompanyId);

}
