package com.void2.careermanagement.dao;

import com.void2.careermanagement.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardDao {

    public int getListCnt();
    public List<BoardDto> getList(int startNum);
    public BoardDto getBoard(int communityNo);
    public void increaseViewCnt(int communityNo);

    public void registBoard(BoardDto board);
    public void updateBoard(BoardDto board);
    public void deleteBoard(int communityNo);
}
