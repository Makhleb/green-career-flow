package com.void2.careermanagement.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SampleController {
    @RequestMapping("/")
    public String root(){
        return "main";
    }
}
