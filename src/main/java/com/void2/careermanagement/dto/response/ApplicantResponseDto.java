package com.void2.careermanagement.dto.response;

import com.void2.careermanagement.dto.GubnDto;
import lombok.Data;

import java.util.List;

/**
 * Created on 2024-12-04 by 안제연
 */
@Data
public class ApplicantResponseDto {
    private String userName;                    // 사용자 이름
    private int userAge;                        // 사용자 나이
    private int jobHistory;                     // 직무 경력
    private int resumeNo;                       // 이력서 번호
    private int likeCount;                      // 좋아요 수
    private String resumeTitle;                 //이력서 제목
    private List<GubnDto> skillList;            // 스킬리스트
    private byte[] companyImage;
    private String companyImageBase64;
}
