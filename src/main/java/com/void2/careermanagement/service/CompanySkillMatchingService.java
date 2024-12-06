package com.void2.careermanagement.service;

import com.void2.careermanagement.dao.CompanySkillMappingDao;
import com.void2.careermanagement.dao.UserResumeDao;
import com.void2.careermanagement.dto.response.CompanySkillMatcingResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2024-12-06 by 안제연
 */
@Service
public class CompanySkillMatchingService {
    private final CompanySkillMappingDao companySkillMappingDao;
    private final UserResumeDao userResumeDao;
    @Autowired
    public CompanySkillMatchingService(CompanySkillMappingDao companySkillMappingDao, UserResumeDao userResumeDao) {
        this.companySkillMappingDao = companySkillMappingDao;
        this.userResumeDao = userResumeDao;
    }

    public List<CompanySkillMatcingResponseDto> getCompanySkillMatchingOfferY() {
        List<CompanySkillMatcingResponseDto> offerYList = companySkillMappingDao.getSkillMatchingOfferY();
        for (int i = 0; i < offerYList.size(); i++) {
            offerYList.get(i).setSkillList(userResumeDao.getSkillListByResumeNo(offerYList.get(i).getResumeNo()));
        }
        return offerYList;}
}
