package com.void2.careermanagement.dao;

import com.void2.careermanagement.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SampleDao {
    List<UserDto> selectUser();
}
