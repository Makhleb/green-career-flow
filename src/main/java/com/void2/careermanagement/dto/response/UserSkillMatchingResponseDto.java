package com.void2.careermanagement.dto.response;

import lombok.Data;

import java.time.LocalDate;

/**
 * Created on 2024-12-06 by 최윤서
 */
@Data
public class UserSkillMatchingResponseDto {

    private String companyId;         // 회사 ID
    private String companyName;
    private String companyAddress;  // 회사 주소
    private int jobPostNo;         // 채용 공고 번호
    private String title;           // 채용 공고 제목
    private int jobHistory;      // 업무 경력
    private LocalDate startDate;    // 시작 날짜
    private LocalDate endDate;
    private String skillCodes;       // 기술 코드
    private String skillCode;       // 기술 코드
    private byte[] companyImage;
    private String companyImageBase64;

//    private List<GubnDto> skillList;

}
