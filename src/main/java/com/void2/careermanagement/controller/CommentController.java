package com.void2.careermanagement.controller;

import com.void2.careermanagement.dto.CommentDto;
import com.void2.careermanagement.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created on 2024-12-03 by 최윤서
 */
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/commentregist")
    public void registcomment(@RequestBody CommentDto commentDto, Model model) {
        System.out.println(commentDto);
        commentService.registComment(commentDto);
    }

}
