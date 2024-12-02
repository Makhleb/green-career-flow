package com.void2.careermanagement.dao;

import com.void2.careermanagement.dto.GubnDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created on 2024-12-01 by 황승현
 */
@Mapper
public interface GubnDao {

    List<GubnDto> getGubnList(String groupCode);
}
