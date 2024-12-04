package com.void2.careermanagement.dao;

import com.void2.careermanagement.dto.MilitaryDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MilitaryDao {
    int militaryInsert(MilitaryDto militaryDto);
}
