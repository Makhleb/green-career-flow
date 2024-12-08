package com.void2.careermanagement.dto;


import lombok.Data;

import java.time.LocalDate;

@Data
public class MilitaryDto {

  private int resumeNo;
  private String enlistDate;
  private String releaseDate;
  private String militaryCode;
}

