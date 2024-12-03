package com.void2.careermanagement.controller;

import com.void2.careermanagement.dto.CommentDto;
import com.void2.careermanagement.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created on 2024-12-03 by 최윤서
 */
@RestController
@RequestMapping("/api/comment")
public class CommentApiController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public int insert(@RequestBody CommentDto commentDto) {
        return commentService.registComment(commentDto);
    }

    @PutMapping
    public int update(@RequestBody CommentDto commentDto) {
        return commentService.update(commentDto);
    }

    @DeleteMapping("/{commentNo}")
    public int delete(@PathVariable("commentNo") int commentNo) {
        return commentService.delete(commentNo);
    }
}
