package com.void2.careermanagement.dao;

import com.void2.careermanagement.dto.CommentDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created on 2024-12-03 by 최윤서
 */
@Mapper
public interface CommentDao {
    public List<CommentDto> getListComment(int communityNo);
}
