package com.void2.careermanagement.dao;

import com.void2.careermanagement.dto.GubnDto;
import com.void2.careermanagement.dto.response.LikeResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created on 2024-12-03 by 황승현
 */
@Mapper
public interface LikeDao {
    /**
     * 값 넣을 때
     */
    int insert(String inputColumnName, String inputId, String receiveColumnName, String likeId, String gubn);

    /**
     * 값 삭제(취소)
     */
    int delete(String inputColumnName, String inputId, String receiveColumnName, String likeId, String gubn);

    /**
     * 값 넣어야하는지 삭제해야하는지 확인용
     */
    int checkLike(String inputColumnName, String inputId, String receiveColumnName, String likeId, String gubn);

    List<LikeResponseDto> getLikeListByCompanyId(String companyId);

    List<LikeResponseDto> getLikeListByCompanyIdTop3(String companyId);
    
    int getCountByCompanyId(String companyId);

    List<GubnDto> selectSkillList(int resumeNo);
}
