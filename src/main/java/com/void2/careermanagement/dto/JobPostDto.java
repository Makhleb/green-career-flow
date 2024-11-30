package com.void2.careermanagement.dto;

import lombok.Data;

@Data
public class JobPostDto {
    private int jobPostNo; // job_post_no
    private String title; // 공고 제목
    private String companyId; // 회사 ID
    private String workCode; // 직무 코드
    private int jobHistory; // 경력
    private Integer jobSalary; // 급여
    private String educationCode; // 학력 코드
    private String jobRankCode; // 직급/직책 코드
    private String workTypeCode; // 근무형태 코드
    private String content; // 상세 내용
    private String educationName;
    private String workName;
    private String jobRankName;
    private String workTypeName;
}