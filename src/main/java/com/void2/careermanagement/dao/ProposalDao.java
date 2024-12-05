package com.void2.careermanagement.dao;

import com.void2.careermanagement.dto.response.ProposalResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created on 2024-12-05 by 최윤서
 */
@Mapper
public interface ProposalDao {

    public List<ProposalResponseDto> getProposalListById(String userId);
    public ProposalResponseDto getProposalById(String proposalId);
}
