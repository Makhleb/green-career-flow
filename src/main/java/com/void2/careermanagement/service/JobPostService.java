package com.void2.careermanagement.service;

import com.void2.careermanagement.dao.JobPostDao;
import com.void2.careermanagement.dto.request.JopPostRequestDto;
import com.void2.careermanagement.dto.response.JobPostResponseDto;
import com.void2.careermanagement.type.GroupCode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
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
     *
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
            if (!benefits.isEmpty()) jobPostDao.insertJobPostBenefit(maxNo, benefits);
            if (!skillList.isEmpty()) jobPostDao.insertJobPostSkill(maxNo, skillList);

            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public JobPostResponseDto getJobDetail(int jobPostNo) {

        List<GroupCode> gubnList = new ArrayList<>();

        gubnList.add(GroupCode.WORK_TYPE);
        gubnList.add(GroupCode.WORK);
        gubnList.add(GroupCode.EDUCATION);
        gubnList.add(GroupCode.JOB_RANK);

        JobPostResponseDto jobPostResponseDto = jobPostDao.getJobDetail(jobPostNo, gubnList.stream().map(Enum::name).toList());
        jobPostResponseDto.setBenefitList(jobPostDao.selectBenefitList(jobPostNo));
        jobPostResponseDto.setSkillList(jobPostDao.selectSkillList(jobPostNo));
        System.out.println(jobPostResponseDto);
        System.out.println(jobPostResponseDto.getBenefitList());
        System.out.println(jobPostResponseDto.getSkillList());
        return jobPostResponseDto;

    }
}
