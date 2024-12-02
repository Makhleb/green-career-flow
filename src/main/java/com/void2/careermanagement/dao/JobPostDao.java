package com.void2.careermanagement.dao;

import com.void2.careermanagement.dto.request.JopPostRequestDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created on 2024-12-02 by 황승현
 */
@Mapper
public interface JobPostDao {
    /**
     * @return 저장된 번호
     */
    int maxJopPostNo();

    void insertJobPost(@Param("jobPost") JopPostRequestDto jopPostRequestDto);

    void insertJobPostBenefit(@Param("jobPostNo") int jobPostNo, @Param("benefitList") List<String> benefitList);

    void insertJobPostSkill(@Param("jobPostNo") int jobPostNo, @Param("skillList") List<String> skillList);
}
