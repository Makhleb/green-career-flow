package com.void2.careermanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created on 2024-12-04 by 최윤서
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProposalDto {
    private int proposalNo;
    private String companyId;
    private String userId;
    private String title;
    private String content;
    private String date;
    private String readDate;
    private String phone;
    private String email;
}
