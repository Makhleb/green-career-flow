package com.void2.careermanagement.service;

import com.void2.careermanagement.dao.*;
import com.void2.careermanagement.dto.LicenseDto;
import com.void2.careermanagement.dto.PotfolioDto;
import com.void2.careermanagement.dto.ResumeSkillDto;
import com.void2.careermanagement.dto.request.ResumeFullRequestDto;
import com.void2.careermanagement.dto.response.ResumeResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created on 2024-12-04 by 황승현
 */
@Service

public class ResumeService {
    private final ResumeDao resumeDao;
    private final ActivityDao activityDao;
    private final EducationDao educationDao;
    private final IntroduceDao introduceDao;
    private final MilitaryDao militaryDao;
    private final LicenseDao licenseDao;
    private final PotfolioDao potfolioDao;
    private final ResumeSkillDao resumeSkillDao;

    public ResumeService(ResumeDao resumeDao, ActivityDao activityDao, EducationDao educationDao, IntroduceDao introduceDao, MilitaryDao militaryDao, LicenseDao licenseDao, PotfolioDao potfolioDao, ResumeSkillDao resumeSkillDao) {
        this.resumeDao = resumeDao;
        this.activityDao = activityDao;
        this.educationDao = educationDao;
        this.introduceDao = introduceDao;
        this.militaryDao = militaryDao;
        this.licenseDao = licenseDao;
        this.potfolioDao = potfolioDao;
        this.resumeSkillDao = resumeSkillDao;
    }

    /**
     * 유효한 이력서 가져오는 함수
     *
     * @param userId
     * @return
     */
    public List<ResumeResponseDto> getValidResumeListByUserId(String userId) {
        return resumeDao.getValidResumeListByUserId(userId);
    }

    /**
     * 이력서 관련 데이터 일괄 저장 서비스
     */
    @Transactional
    public int insertFullResume(ResumeFullRequestDto resumeFullRequestDto) {
        // 1. Resume 테이블에 삽입
        resumeDao.insertResume(resumeFullRequestDto.getResume());
        int resumeNo = resumeDao.maxResumeNo();

        // 2. Optional을 사용하여 insert를 처리
        Optional.ofNullable(resumeFullRequestDto.getActivity())
                .ifPresent(activity -> activityDao.insertActivity(activity, resumeNo));

        Optional.ofNullable(resumeFullRequestDto.getEducation())
                .ifPresent(education -> educationDao.insertEducation(education, resumeNo));

        Optional.ofNullable(resumeFullRequestDto.getIntroduce())
                .ifPresent(introduce -> introduceDao.insertIntroduce(introduce, resumeNo));

        Optional.ofNullable(resumeFullRequestDto.getLicense())
                .ifPresent(license -> licenseDao.insertLicense(license, resumeNo));

        Optional.ofNullable(resumeFullRequestDto.getMilitary())
                .ifPresent(military -> militaryDao.insertMilitary(military, resumeNo));

        Optional.ofNullable(resumeFullRequestDto.getPotfolio())
                .ifPresent(potfolio -> potfolioDao.insertPotfolio(potfolio, resumeNo));

        Optional.ofNullable(resumeFullRequestDto.getResumeSkill())
                .ifPresent(resumeSkill -> resumeSkillDao.insertResumeSkill(resumeSkill, resumeNo));
        return resumeNo;
    }

}
