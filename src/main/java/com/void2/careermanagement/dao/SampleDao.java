package com.vo2d.careermanagement.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SampleDao {
    int insertSample(String id);
}
