package com.void2.careermanagement.dto.response;

import com.void2.careermanagement.dto.GubnDto;
import lombok.Data;

import java.util.List;

/**
 * Created on 2024-12-06 by 안제연
 */

@Data
public class CompanySkillMatcingResponseDto {
    private String userId;        // 사용자 ID
    private int resumeNo;           // 이력서 번호
    private String userName;      // 사용자 이름
    private String title;         // 이력서 제목
    private String userGender;    // 사용자 성별
    private int jobHistory;    // 직업 경력
    private String wishSalary;
    private int userAge;
    private List<GubnDto> skillList;  // 스킬리스트
}
