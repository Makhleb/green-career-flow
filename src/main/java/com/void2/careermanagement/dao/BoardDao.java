package com.void2.careermanagement.dao;

import com.void2.careermanagement.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardDao {

    public List<BoardDto> getList();
    public BoardDto getBoard(int communityNo);
    public void increaseViewCnt(int communityNo);

}
