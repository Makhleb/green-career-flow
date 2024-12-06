package com.void2.careermanagement.dto.response;

import com.void2.careermanagement.dto.*;
import com.void2.careermanagement.dto.request.ResumeRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeFullResponseDto {
    private ResumeResponseDto resume;
    private List<ActivityDto> activity;
    private EducationDto education;
    private List<IntroduceDto> introduce;
    private List<LicenseDto> license;
    private MilitaryDto military;
    private List<PotfolioDto> potfolio;
    private List<ResumeSkillDto> resumeSkill;
}
