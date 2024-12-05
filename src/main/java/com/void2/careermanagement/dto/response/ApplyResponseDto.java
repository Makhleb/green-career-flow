package com.void2.careermanagement.dto.response;

import com.void2.careermanagement.dto.GubnDto;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

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
    private String userId;
    private String userName;
    private int jobHistory;
    private int userAge;
    private List<GubnDto> skillList;
}
