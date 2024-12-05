package com.void2.careermanagement.service;

import com.void2.careermanagement.dao.ProposalDao;
import com.void2.careermanagement.dto.response.ProposalResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2024-12-05 by 최윤서
 */
@Service
public class ProposalService{

    public final ProposalDao proposalDao;

    public ProposalService(ProposalDao proposalDao) {
        this.proposalDao = proposalDao;
    }

    public List<ProposalResponseDto> getProposalListById(String userId){
        List<ProposalResponseDto> proposalDtoList = proposalDao.getProposalListById(userId);
        return proposalDtoList;
    }

    public ProposalResponseDto getProposalById(String userId){
        ProposalResponseDto proposalDto = proposalDao.getProposalById(userId);
        return proposalDto;
    }

}
