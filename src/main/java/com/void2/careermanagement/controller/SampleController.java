package com.vo2d.careermanagement.controller;


import com.vo2d.careermanagement.dao.SampleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SampleController {

    private final SampleDao sampleDao;

    public SampleController(SampleDao sampleDao) {
        this.sampleDao = sampleDao;
    }

    @RequestMapping("/")
    public String root(){
        return "main";
    }

    @PostMapping("/sample-insert")
    public String sampleInsert(@RequestParam("id") String id){
        System.out.println("id            :"+ id);
        if(sampleDao.insertSample(id) > 0){
            System.out.println("성공");
        } else{
            System.out.println("실패");
        }
        return "redirect:/";
    }
}
