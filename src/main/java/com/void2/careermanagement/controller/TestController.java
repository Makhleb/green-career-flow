package com.void2.careermanagement.controller;

import com.void2.careermanagement.dao.*;
import com.void2.careermanagement.dto.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// todo 그냥 지우세요

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
    public int activity(@RequestBody ActivityDto activityDto) {
        return activityDao.insertActivity(activityDto);
    }

    @PostMapping("/education")
    public int activity(@RequestBody EducationDto educationDto) {
        return educationDao.insertEducation(educationDto);
    }

    @PostMapping("/introduce")
    public int activity(@RequestBody IntroduceDto introduceDto) {
        return introduceDao.insertIntroduce(introduceDto);
    }

    @PostMapping("/license")
    public int activity(@RequestBody LicenseDto LicenseDto) {
        return licenseDao.insertLicense(LicenseDto);
    }

    @PostMapping("/military")
    public int activity(@RequestBody MilitaryDto MilitaryDto) {
        return militaryDao.insertMilitary(MilitaryDto);
    }

    @PostMapping("/potfolio")
    public int activity(@RequestBody PotfolioDto PotfolioDto) {
        return potfolioDao.insertPotfolio(PotfolioDto);
    }

    @PostMapping("/resume-skill")
    public int activity(@RequestBody ResumeSkillDto ResumeSkillDto) {
        return resumeSkillDao.insertResumeSkill(ResumeSkillDto);
    }

}
