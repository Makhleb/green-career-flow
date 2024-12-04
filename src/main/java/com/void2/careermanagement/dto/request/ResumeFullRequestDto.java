package com.void2.careermanagement.dto.request;

import com.void2.careermanagement.dto.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeFullRequestDto {
    private ResumeRequestDto resume;
    private ActivityDto activity;
    private EducationDto education;
    private IntroduceDto introduce;
    private LicenseDto license;
    private MilitaryDto military;
    private PotfolioDto potfolio;
    private ResumeSkillDto resumeSkill;
}
