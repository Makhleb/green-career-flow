package com.void2.careermanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardDto {
    public int communityNo;
    public String userId;
    public String title;
    public String content;
    public int viewCnt;
    public String createDate;
    public String modifyDate;

}
