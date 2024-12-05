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
     * todo 데이터 반복해서 insert하지말고 values로 한번에 넣으세요
     */
    @Transactional
    public void insertFullResume(ResumeFullRequestDto resumeFullRequestDto) {
        // 1. Resume 테이블에 삽입
        resumeDao.insertResume(resumeFullRequestDto.getResume());
        activityDao.insertActivity(resumeFullRequestDto.getActivity());
        educationDao.insertEducation(resumeFullRequestDto.getEducation());
        introduceDao.insertIntroduce(resumeFullRequestDto.getIntroduce());
        licenseDao.insertLicense(resumeFullRequestDto.getLicense());
        militaryDao.insertMilitary(resumeFullRequestDto.getMilitary());
        potfolioDao.insertPotfolio(resumeFullRequestDto.getPotfolio());
        resumeSkillDao.insertResumeSkill(resumeFullRequestDto.getResumeSkill());
    }
}
