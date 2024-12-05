package com.void2.careermanagement.service;

import com.void2.careermanagement.dao.ProposalDao;
import com.void2.careermanagement.dto.ProposalDto;
import com.void2.careermanagement.dto.response.ProposalResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2024-12-05 by 최윤서
 */
@Service
public class ProposalService {

    public final ProposalDao proposalDao;

    public ProposalService(ProposalDao proposalDao) {
        this.proposalDao = proposalDao;
    }

    public List<ProposalResponseDto> getProposalListByUserId(String userId) {
        List<ProposalResponseDto> proposalDtoList = proposalDao.getProposalListByUserId(userId);
        return proposalDtoList;
    }

    public ProposalResponseDto getProposalByUserId(int proposalNo) {
        ProposalResponseDto proposalDto = proposalDao.getProposalByUserId(proposalNo);
        return proposalDto;
    }

    public List<ProposalResponseDto> getProposalListByCompanyId(String companyId) {
        List<ProposalResponseDto> proposalDtoList = proposalDao.getProposalListByCompanyId(companyId);
        return proposalDtoList;
    }

    public ProposalResponseDto getProposalByCompanyId(int proposalNo) {
        ProposalResponseDto proposalDto = proposalDao.getProposalByCompanyId(proposalNo);
        return proposalDto;
    }

    public int registProposalByCompanyId(ProposalDto proposalDto) {
        int result = proposalDao.registProposalByCompanyId(proposalDto);
        return result;
    }

    public void updateReadDate(int proposalNo) {
        if (proposalDao.checkReadDate(proposalNo) == 0) {
            proposalDao.updateReadDate(proposalNo);
        }
    }
}
