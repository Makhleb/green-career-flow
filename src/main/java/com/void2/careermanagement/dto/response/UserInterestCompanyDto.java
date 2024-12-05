package com.void2.careermanagement.dto.response;

import lombok.Data;

/**
 * Created on 2024-12-05 by 안제연
 */

@Data
public class UserInterestCompanyDto {
    private String companyId;
    private String companyImage;
    private String companyName;
    private String companyAddress;
    private String companyAddressDetail;
    private String companyEmail;
}
