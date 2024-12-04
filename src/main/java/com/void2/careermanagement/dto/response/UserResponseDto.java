package com.void2.careermanagement.dto.response;

import com.void2.careermanagement.dto.GubnDto;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created on 2024-12-03 by 안제연
 */
@Data
public class UserResponseDto {
    private int jobPostNo;                      // 구인 공고 번호
    private String jobPostTitle;                // 구인 공고 제목
    private String passYn;                      // 합격 여부 ('Y' or 'N') 미확인 NULL
    private int resumeNo;                       // 이력서 번호
    private int jobHistory;                  // 직무 경력
    private String userId;                         // 사용자 ID
    private String userName;                    // 사용자 이름
    private String userGender;                  // 사용자 성별
    private int userAge;                        // 사용자 나이
    private LocalDateTime aplcHstrDate;         // 지원일시
    private List<GubnDto> skillList;            // 스킬리스트
}
