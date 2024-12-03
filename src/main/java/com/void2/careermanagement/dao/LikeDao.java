package com.void2.careermanagement.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * Created on 2024-12-03 by 황승현
 */
@Mapper
public interface LikeDao {
    int insertOrDelete(String id, String likeId, String gubn);
}
