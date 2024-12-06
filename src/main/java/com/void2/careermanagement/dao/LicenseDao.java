package com.void2.careermanagement.dao;

import com.void2.careermanagement.dto.LicenseDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LicenseDao {
    int insertLicense(@Param("list") List<LicenseDto> licenseDtoList,@Param("resumeNoPk") int resumeNoPk);
}
