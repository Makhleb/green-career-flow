package com.void2.careermanagement.service;

import com.void2.careermanagement.dao.JobPostDao;
import com.void2.careermanagement.dto.request.JopPostRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2024-12-02 by 황승현
 */
@Service
public class JobPostService {
    private final JobPostDao jobPostDao;

    public JobPostService(JobPostDao jobPostDao) {
        this.jobPostDao = jobPostDao;
    }

    /**
     * 채용공고 저장
     * @param jopPostRequestDto
     * @return 성공 시 1 실패 0
     */
    public int jobPostInsert(JopPostRequestDto jopPostRequestDto) {
        try {
            jopPostRequestDto.setCompanyId("company01");
            jobPostDao.insertJobPost(jopPostRequestDto);
            int maxNo = jobPostDao.maxJopPostNo();

            System.out.println(jopPostRequestDto);
            List<String> benefits = jopPostRequestDto.getBenefitList(); //복리후생
            List<String> skillList = jopPostRequestDto.getSkillList(); // 스킬리스트
            if(!benefits.isEmpty()) jobPostDao.insertJobPostBenefit(maxNo, benefits);
            if(!skillList.isEmpty()) jobPostDao.insertJobPostSkill(maxNo, skillList);

            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
