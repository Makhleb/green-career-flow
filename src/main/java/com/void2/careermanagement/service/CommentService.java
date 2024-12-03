package com.void2.careermanagement.service;

import com.void2.careermanagement.dao.CommentDao;
import com.void2.careermanagement.dto.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2024-12-03 by 최윤서
 */
@Service
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    public List<CommentDto> getListComment(int communityNo) {
        List<CommentDto> list = commentDao.getListComment(communityNo);
        return list;
    }

    public void registComment(CommentDto commentDto) {
        commentDao.registComment(commentDto);
    }
}
