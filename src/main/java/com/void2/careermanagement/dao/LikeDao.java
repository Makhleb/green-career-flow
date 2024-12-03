package com.void2.careermanagement.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * Created on 2024-12-03 by 황승현
 */
@Mapper
public interface LikeDao {
    int insert(String inputColumnName, String inputId, String receiveColumnName, String likeId, String gubn);
    int delete(String inputColumnName, String inputId, String receiveColumnName, String likeId, String gubn);

    int checkLike(String inputColumnName, String inputId, String receiveColumnName, String likeId, String gubn);
}
