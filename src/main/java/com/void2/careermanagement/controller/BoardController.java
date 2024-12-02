package com.void2.careermanagement.controller;


import com.void2.careermanagement.dto.BoardDto;
import com.void2.careermanagement.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @RequestMapping("/boardmain")
    public String boardmain(Model model){
        List<BoardDto> list = boardService.getList();
        model.addAttribute("list", list);
        return "/board/board-main";
    }

    @RequestMapping("/registform")
    public String registform() {
        return "/board/board-registform";
    }

    @RequestMapping("/detail/{communityNo}")
    public String detail(@PathVariable("communityNo")int communityNo, Model model){
        BoardDto board = boardService.getBoard(communityNo);
        boardService.increaseViewCnt(communityNo);
        model.addAttribute("board", board);
        return "/board/board-detail";
    }

    @RequestMapping("/regist")
    public String regist(BoardDto b){
        BoardDto board = boardService.registBoard(b);
        System.out.println(board);
        return "redirect:/board/board-main";
    }




}

