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
@RequestMapping("/Board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @RequestMapping("/boardmain")
    public String boardmain(Model model){
        List<BoardDto> list = boardService.getList();
        model.addAttribute("list", list);
        System.out.println(list);
        return "Board/board-main";
    }

    @RequestMapping("/detail/{communityNo}")
    public String detail(@PathVariable("communityNo")int communityNo, Model model){
        System.out.println(communityNo);
        BoardDto board = boardService.getBoard(communityNo);
        model.addAttribute("board", board);
        return "Board/board-detail";
    }

//    @RequestMapping("/registForm")
//    public String registForm() {
//        return "registForm";
//    }

//    @RequestMapping("/regiest")
//    public String regist(){
//
//        return "redirect:/BoardMain";
//    }




}

