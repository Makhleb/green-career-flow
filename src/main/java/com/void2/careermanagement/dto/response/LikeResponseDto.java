package com.void2.careermanagement.dto.response;

import com.void2.careermanagement.dto.GubnDto;
import lombok.Data;

import java.util.List;

/**
 * Created on 2024-12-06 by 황승현
 */
@Data
public class LikeResponseDto {
    private String userId;
    private String userName;
    private int resumeNo;
    private String jobHistory;
    private int userAge;
    private List<GubnDto> skillList;
}
