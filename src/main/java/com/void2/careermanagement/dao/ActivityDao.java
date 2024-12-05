package com.void2.careermanagement.dao;

import com.void2.careermanagement.dto.ActivityDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ActivityDao {
    int insertActivity(@Param("list") List<ActivityDto> activityDtoList);
}
