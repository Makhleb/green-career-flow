package com.void2.careermanagement.dao;

import com.void2.careermanagement.dto.response.UserInterestCompanyDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created on 2024-12-05 by 안제연
 */

@Mapper
public interface UserInterestCompanyDao {
    //관심기업 조회
    public List<UserInterestCompanyDto> getInterestList(String id);
    public void deleteInterestCompany(@RequestParam("companyId") String companyId, @RequestParam("userId") String userId);
}
