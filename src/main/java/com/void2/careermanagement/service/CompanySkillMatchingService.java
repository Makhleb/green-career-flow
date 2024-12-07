package com.void2.careermanagement.service;

import com.void2.careermanagement.dao.CompanySkillMappingDao;
import com.void2.careermanagement.dao.UserResumeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
