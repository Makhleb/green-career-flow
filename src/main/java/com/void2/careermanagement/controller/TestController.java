package com.void2.careermanagement.controller;

import com.void2.careermanagement.dao.*;
import com.void2.careermanagement.dto.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// todo 테스트 컨트롤러 그냥 지우세요

@RestController
@RequestMapping("/testtest")
public class TestController {

    private final ActivityDao activityDao;
    private final EducationDao educationDao;
    private final IntroduceDao introduceDao;
    private final LicenseDao licenseDao;
    private final MilitaryDao militaryDao;
    private final PotfolioDao potfolioDao;
    private final ResumeSkillDao resumeSkillDao;

    public TestController(ActivityDao activityDao, EducationDao educationDao, IntroduceDao introduceDao, LicenseDao licenseDao, MilitaryDao militaryDao, PotfolioDao potfolioDao, ResumeSkillDao resumeSkillDao) {
        this.activityDao = activityDao;
        this.educationDao = educationDao;
        this.introduceDao = introduceDao;
        this.licenseDao = licenseDao;
        this.militaryDao = militaryDao;
        this.potfolioDao = potfolioDao;
        this.resumeSkillDao = resumeSkillDao;
    }

    @PostMapping("/activity")
    public void activity(@RequestBody List<ActivityDto> activityDtoList) {
        activityDao.insertActivity(activityDtoList,11);
    }

    @PostMapping("/education")
    public void activity2(@RequestBody EducationDto educationDto) {
        educationDao.insertEducation(educationDto,11);
    }

    @PostMapping("/introduce")
    public void introduce(@RequestBody List<IntroduceDto> introduceDtoList) {
        introduceDao.insertIntroduce(introduceDtoList,10);
    }

    @PostMapping("/license")
    public void activity3(@RequestBody List<LicenseDto> LicenseDto) {
        licenseDao.insertLicense(LicenseDto,10);
    }

    @PostMapping("/military")
    public void activity4(@RequestBody MilitaryDto MilitaryDto) {
        militaryDao.insertMilitary(MilitaryDto,13);
    }

    @PostMapping("/potfolio")
    public void activity5(@RequestBody List<PotfolioDto> PotfolioDto) {
        potfolioDao.insertPotfolio(PotfolioDto,15);
    }

    @PostMapping("/resume-skill")
    public void activity6(@RequestBody List<ResumeSkillDto> ResumeSkillDto) {
        resumeSkillDao.insertResumeSkill(ResumeSkillDto,10);
    }

}
