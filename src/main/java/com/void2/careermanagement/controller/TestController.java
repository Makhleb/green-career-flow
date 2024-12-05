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
    public int activity(@RequestBody List<ActivityDto> activityDtoList) {
        return activityDao.insertActivity(activityDtoList);
    }

    @PostMapping("/education")
    public int activity2(@RequestBody EducationDto educationDto) {
        return educationDao.insertEducation(educationDto);
    }

    @PostMapping("/introduce")
    public void introduce(@RequestBody List<IntroduceDto> introduceDtoList) {
        introduceDao.insertIntroduce(introduceDtoList);
    }

    @PostMapping("/license")
    public int activity3(@RequestBody List<LicenseDto> LicenseDto) {
        return licenseDao.insertLicense(LicenseDto);
    }

    @PostMapping("/military")
    public int activity4(@RequestBody MilitaryDto MilitaryDto) {
        return militaryDao.insertMilitary(MilitaryDto);
    }

    @PostMapping("/potfolio")
    public int activity5(@RequestBody List<PotfolioDto> PotfolioDto) {
        return potfolioDao.insertPotfolio(PotfolioDto);
    }

    @PostMapping("/resume-skill")
    public int activity6(@RequestBody List<ResumeSkillDto> ResumeSkillDto) {
        return resumeSkillDao.insertResumeSkill(ResumeSkillDto);
    }

}
