package com.void2.careermanagement.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Created on 2024-12-04 by 최윤서
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MyPageScrapDto {
        private String userId;         // 사용자 ID
        private int jobPostNo;         // 공고 번호
        private String title;          // 공고 제목
        private LocalDate endDate;     // 공고 마감일
        private String companyId;         // 회사 ID
        private String companyName;    // 회사 이름

    }
