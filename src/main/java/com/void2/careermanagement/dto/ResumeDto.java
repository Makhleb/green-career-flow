package com.void2.careermanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDto {
    private int resumeNo;
    private String title;
    private String address;
    private String addressDetail;
    private String zonecode;
    private String userId;
    private byte[] image;
    private Integer jobHistory;
    private String wishArea;
    private Integer wishSalary;
    private String wishTime;
    private String workCode;
    private String portfolioLink;
    private Character offerYn;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
}
