package com.void2.careermanagement.dao;

import com.void2.careermanagement.dto.MilitaryDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MilitaryDao {
    int insertMilitary(@Param("M")MilitaryDto militaryDto,@Param("resumeNoPk") int resumeNoPk);
}
