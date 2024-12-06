package com.void2.careermanagement.dao;

import com.void2.careermanagement.dto.ActivityDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ActivityDao {
    void insertActivity(@Param("list") List<ActivityDto> activityDtoList, @Param("resumeNoPk") int resumeNo);
}
