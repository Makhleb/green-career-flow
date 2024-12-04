package com.void2.careermanagement.dto.response;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResumeResponseDto {

  private int resumeNo;
  private String title;
  private String address;
  private String addressDetail;
  private String zonecode;
  private String userId;
  private byte[] image;
  private String wishArea;
  private int wishSalary;
  private String wishTime;
  private String workCode;
  private String portfolioLink;
  private String offerYn;
  private LocalDateTime createDate;
  private LocalDateTime modifyDate;
  private int jobHistory;
}
