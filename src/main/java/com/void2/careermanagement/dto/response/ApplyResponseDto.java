package com.void2.careermanagement.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created on 2024-12-04 by 황승현
 */
@Data
public class ApplyResponseDto {
    private int jobPostNo;
    private int resumeNo;
    private LocalDateTime aplcHstrDate;
    private String passYn;
    private String resumeTitle;
    private String companyId;
    private String companyName;
    private LocalDateTime jobPostStartDate;
    private LocalDateTime jobPostEndDate;
    private String jobPostTitle;
}
