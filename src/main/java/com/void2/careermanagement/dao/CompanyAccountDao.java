package com.void2.careermanagement.dao;

import com.void2.careermanagement.dto.CompanyDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CompanyAccountDao {
    CompanyDto loginCompanySelect(@Param("C") CompanyDto companyDto);

    int companyInsert(@Param("C") CompanyDto companyDto);

    int findCompanyIdSelect(@Param("companyId") String companyId);

    int companyUpdate(@Param("C") CompanyDto companyDto);

    int companyDelete(String companyId);

    CompanyDto sessionSelect(@Param("companyId") String companyId);
}
