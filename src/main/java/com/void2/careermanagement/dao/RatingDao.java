package com.void2.careermanagement.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * Created on 2024-12-08 by 황승현
 */
@Mapper
public interface RatingDao {
    int getUserRating(String companyId, String userId);

    void delete(String companyId, String userId);

    void insert(String companyId, String userId, int score);
}
