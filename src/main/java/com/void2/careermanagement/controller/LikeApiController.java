package com.void2.careermanagement.controller;

import com.void2.careermanagement.service.LikeService;
import com.void2.careermanagement.util.SessionUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2024-12-03 by 황승현
 */
@RestController
@RequestMapping("/api/like")
public class LikeApiController {

    private final LikeService likeService;

    public LikeApiController(LikeService likeService) {
        this.likeService = likeService;
    }

    /**
     * @param likeId : 구직자 id 또는 기업 id
     */
    @PostMapping("/{likeId}")
    public int insertLike(@PathVariable String likeId, HttpSession session) {
        if(session.getAttribute("user") == null) {
            return -1;
        }
        String userType = session.getAttribute("userType").toString();
        String id = SessionUtil.getSessionUserId(session);

        return likeService.insertOrDelete(id, likeId, userType);
    }
}
