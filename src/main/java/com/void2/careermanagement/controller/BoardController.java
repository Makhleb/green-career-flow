package com.void2.careermanagement.controller;


import com.void2.careermanagement.dto.BoardDto;
import com.void2.careermanagement.dto.CommentDto;
import com.void2.careermanagement.service.BoardService;
import com.void2.careermanagement.service.CommentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private CommentService commentService;

    @RequestMapping("/boardmain")
    public String boardmain(Model model){
        int listCnt = boardService.getListCnt();
        List<BoardDto> list = boardService.getList(0);
        model.addAttribute("list", list);
        model.addAttribute("listCnt", listCnt);
        return "/board/board-main";
    }

    @RequestMapping("/registform")
    public String registform() {
        return "/board/board-registform";
    }

    @RequestMapping("/updateform/{communityNo}")
    public String updateform(@PathVariable("communityNo")int communityNo, Model model) {
        BoardDto board = boardService.getBoard(communityNo);
        model.addAttribute("board",board);
        model.addAttribute("communityNo", communityNo);
        return "/board/board-updateform";
    }

    @RequestMapping("/detail/{communityNo}")
    public String detail(@PathVariable("communityNo")int communityNo, Model model, HttpSession session){
        if(session.getAttribute("user")==null)return "redirect:/user/account/login";
        BoardDto board = boardService.getBoard(communityNo);
        boardService.increaseViewCnt(communityNo);
        List<CommentDto> cList = commentService.getListComment(communityNo);
        int commentCnt = cList.size();
        model.addAttribute("commentCnt", commentCnt);
        model.addAttribute("cList",cList);
        model.addAttribute("board", board);
        return "/board/board-detail";
    }

    @RequestMapping("/regist")
    public String regist(BoardDto b){
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        BoardDto board = BoardDto.builder().title(b.getTitle()).content(b.getContent()).userId(b.getUserId())
                        .createDate(now).build();
        boardService.registBoard(board);
        return "redirect:/board/boardmain";
    }

    @RequestMapping("/update")
    public String update(BoardDto b){
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        BoardDto board = BoardDto.builder().communityNo(b.getCommunityNo()).title(b.getTitle()).content(b.getContent()).modifyDate(now).build();
        boardService.updateBoard(board);
        return "redirect:/board/detail/"+b.getCommunityNo();
    }

    @RequestMapping("/delete/{communityNo}")
    public String delete(@PathVariable("communityNo")int communityNo){
        boardService.deleteBoard(communityNo);
        return "redirect:/board/boardmain";
    }



}

