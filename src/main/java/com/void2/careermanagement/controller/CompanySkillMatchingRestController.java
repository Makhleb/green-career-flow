package com.void2.careermanagement.controller;

import com.void2.careermanagement.dao.CompanySkillMappingDao;
import com.void2.careermanagement.dao.UserResumeDao;
import com.void2.careermanagement.dto.response.CompanySkillMatcingResponseDto;
import com.void2.careermanagement.service.CompanySkillMatchingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created on 2024-12-06 by 안제연
 */

@RestController
@RequestMapping("/api/companySkillMatching")
public class CompanySkillMatchingRestController {
    private final CompanySkillMatchingService companySkillMatchingService;
    private final CompanySkillMappingDao companySkillMappingDao;
    private final UserResumeDao userResumeDao;

    public CompanySkillMatchingRestController(CompanySkillMappingDao companySkillMappingDao,
                                              UserResumeDao userResumeDao,
                                              CompanySkillMatchingService companySkillMatchingService) {
        this.companySkillMappingDao = companySkillMappingDao;
        this.userResumeDao = userResumeDao;
        this.companySkillMatchingService = companySkillMatchingService;
    }

    @GetMapping("/select")
    public List<CompanySkillMatcingResponseDto> select(@RequestParam("skillCode") String skillCode) {
        System.out.println(skillCode);
        List<CompanySkillMatcingResponseDto> skillMatchingList = null;
        if(!skillCode.equals("none")){
            skillMatchingList =companySkillMappingDao.getSkillMatchingOfferYBySkillCode(skillCode);
            for(int i=0;i<skillMatchingList.size();i++){
                skillMatchingList.get(i).setSkillList(userResumeDao.getSkillListByResumeNo(skillMatchingList.get(i).getResumeNo()));
            }
        }
        else{
            skillMatchingList = companySkillMatchingService.getCompanySkillMatchingOfferY();

        }
        return skillMatchingList;
    }

}
