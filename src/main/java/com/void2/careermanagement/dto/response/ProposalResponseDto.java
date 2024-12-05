package com.void2.careermanagement.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Created on 2024-12-05 by 최윤서
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProposalResponseDto {

    private int proposalNo;
    private String title;       // 제안 제목
    private String content;
    private LocalDateTime date;     // 제안 날짜
    private LocalDateTime readDate; // 구직자가 읽은 날짜
    private String companyName; // 기업이름
    private String phone;
    private String email;
    private String userName;    // 구직자 이름

}
