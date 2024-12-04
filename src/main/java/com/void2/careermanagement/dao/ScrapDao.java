package com.void2.careermanagement.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * Created on 2024-12-03 by 황승현
 */
@Mapper
public interface ScrapDao {
    int checkScrap(String userId, int jobPostNo);
    int insert(String userId, int jobPostNo);
    int delete(String userId, int jobPostNo);
}
