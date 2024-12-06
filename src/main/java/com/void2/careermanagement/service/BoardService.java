package com.void2.careermanagement.service;

import com.void2.careermanagement.dao.BoardDao;
import com.void2.careermanagement.dto.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardDao boardDao;

    public int getListCnt() {
        int ListCnt = boardDao.getListCnt();
        return ListCnt;
    }

    public List<BoardDto> getList(int startNum) {
        List<BoardDto> list = boardDao.getList(startNum);
        return list;
    }

    public BoardDto getBoard(int communityNo) {
        BoardDto board = boardDao.getBoard(communityNo);
        return board;
    }

    public void increaseViewCnt(int communityNo) {
        boardDao.increaseViewCnt(communityNo);
    }

    public void registBoard(BoardDto board) {
        boardDao.registBoard(board);
    }

    public void updateBoard(BoardDto board) {
        boardDao.updateBoard(board);
    }

    public int deleteBoard(int communityNo) {
        return boardDao.deleteBoard(communityNo);
    }
}
