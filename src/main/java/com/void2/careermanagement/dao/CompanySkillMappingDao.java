package com.void2.careermanagement.dao;

import com.void2.careermanagement.dto.response.CompanySkillMatcingResponseDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created on 2024-12-06 by 안제연
 */
@Mapper
public interface CompanySkillMappingDao {
    List<CompanySkillMatcingResponseDto> getSkillMatchingList(@RequestParam("companyId") String companyId, @RequestParam("skillCode") String skillCode);
}
