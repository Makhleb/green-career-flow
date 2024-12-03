package com.void2.careermanagement.controller;


import com.void2.careermanagement.dto.CompanyDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Base64;

@Controller
public class SampleController {
    @RequestMapping("/")
    public String root(){
        return "main";
    }
}
