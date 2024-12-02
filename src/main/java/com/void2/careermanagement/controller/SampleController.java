package com.void2.careermanagement.controller;


import com.void2.careermanagement.dao.SampleDao;
import com.void2.careermanagement.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SampleController {

    @RequestMapping("/")
    public String root(){
        return "main";
    }
}
