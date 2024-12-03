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

    public int registComment(CommentDto commentDto) {
        try {
            commentDao.registComment(commentDto);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int delete(int commentNo) {

        try {
            commentDao.delete(commentNo);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int update(CommentDto commentDto) {
        try {
            commentDao.update(commentDto);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
