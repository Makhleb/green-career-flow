package com.void2.careermanagement.controller;

import com.void2.careermanagement.dto.BoardDto;
import com.void2.careermanagement.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created on 2024-12-03 by 최윤서
 */
@RestController
@RequestMapping("/api/board")
public class BoardApiController {

    @Autowired
    private BoardService boardService;

    @GetMapping
    public List<BoardDto> getList(@RequestParam("pageNum") int pageNum) {
        List<BoardDto> list = boardService.getList(pageNum);
        return list;
    }
}
