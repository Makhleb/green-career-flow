package com.void2.careermanagement.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ActivityDto {
  private int resumeNo;
  private int order;
  private LocalDate startDate;
  private LocalDate endDate;
  private String activityCenterName;
  private String activityContent;
  private String activityType;
}
