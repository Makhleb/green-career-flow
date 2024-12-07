package com.void2.careermanagement.dao;

import com.void2.careermanagement.dto.EducationDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EducationDao {
    void insertEducation(@Param("E")EducationDto educationDto,@Param("resumeNoPk") int resumeNoPk);
    EducationDto getEducation(@Param("resumeNo")int resumeNo);
}
