package com.void2.careermanagement.service;

import com.void2.careermanagement.dao.LikeDao;
import org.springframework.stereotype.Service;

/**
 * Created on 2024-12-03 by 황승현
 */
@Service
public class LikeService {
    private final LikeDao likeDao;

    public LikeService(LikeDao likeDao) {
        this.likeDao = likeDao;
    }

    public int insertOrDelete(String id, String likeId, String gubn) {
        return likeDao.insertOrDelete(id, likeId, gubn);
    }
}
