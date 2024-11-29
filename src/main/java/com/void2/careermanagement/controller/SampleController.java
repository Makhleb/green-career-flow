package com.void2.careermanagement.controller;


import com.void2.careermanagement.dao.SampleDao;
import com.void2.careermanagement.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SampleController {

    private final SampleDao sampleDao;

    public SampleController(SampleDao sampleDao) {
        this.sampleDao = sampleDao;
    }

    @RequestMapping("/")
    public String root(){
        List<UserDto> resultList = sampleDao.selectUser();

        for(UserDto item : resultList){
            System.out.println(item);
        }
        return "main";
    }

    @GetMapping("/sample-user")
    public String sampleInsert(@RequestParam("id") String id){
        return "redirect:/";
    }
}
