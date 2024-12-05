package com.void2.careermanagement.dao;

import com.void2.careermanagement.dto.ProposalDto;
import com.void2.careermanagement.dto.response.ProposalResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created on 2024-12-05 by 최윤서
 */
@Mapper
public interface ProposalDao {

    public List<ProposalResponseDto> getProposalListByUserId(String userId);
    public ProposalResponseDto getProposalByUserId(int proposalNo);

    public List<ProposalResponseDto> getProposalListByCompanyId(String companyId);
    public ProposalResponseDto getProposalByCompanyId(int proposalNo);
    public int registProposalByCompanyId(ProposalDto proposalDto);

    void updateReadDate(int proposalNo);

    int checkReadDate(int proposalNo);
}
