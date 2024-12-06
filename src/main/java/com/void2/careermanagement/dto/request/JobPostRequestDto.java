package com.void2.careermanagement.dto.request;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created on 2024-12-02 by 황승현
 */
@Data
public class JobPostRequestDto {
    private int jobPostNo;
    private String companyId;
    private String title;
    private String workCode;
    private int jobHistory;
    private int jobSalary;
    private String educationCode;
    private String jobRankCode;
    private String workTypeCode;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String content;
    private String workCondition;
    private int process;
    private String method;
    private String addNotice;
    private String managerName;
    private String managerPhone;
    private String managerEmail;
    private List<String> benefitList;
    private List<String> skillList;
}
