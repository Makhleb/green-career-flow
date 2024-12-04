package com.void2.careermanagement.controller;

import com.void2.careermanagement.dto.UserDto;
import com.void2.careermanagement.dto.response.CompanyResponseDto;
import com.void2.careermanagement.dto.response.UserResponseDto;
import com.void2.careermanagement.service.CompanyService;
import com.void2.careermanagement.service.UserResumeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created on 2024-12-02 by 안제연
 */

@Controller
public class MainController {
    private final CompanyService companyService;

    private final UserResumeService userResumeService;

    @Autowired
    public MainController(CompanyService companyService, UserResumeService userResumeService) {
        this.companyService = companyService;
        this.userResumeService = userResumeService;
    }



    @RequestMapping("/")
    public String root(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            getHighRatingCompanyList(model);
            getFastDeadLineList(model);
        } else {
            String userType = (String) session.getAttribute("userType");
            if (userType.equals("U")) {
                String isEmpty = "Empty";

                UserDto sessionUser = (UserDto) session.getAttribute("user");
                List<CompanyResponseDto> lList = companyService.getLikeCompanyList(sessionUser.getUserId());
                if (!lList.isEmpty()) {
                    for (CompanyResponseDto l : lList) System.out.println(l);
                    isEmpty = "notEmpty";
                    model.addAttribute("lList", lList);

                }
                model.addAttribute("isEmpty", isEmpty);
                getHighRatingCompanyList(model);
                getFastDeadLineList(model);
            }
            //기업
            else {
                getHighRatingCompanyList(model);

                //기업으로부터 좋아요를 많이 받은 구직자
                List<UserResponseDto> uList = userResumeService.getUserReumeList();

                for(UserResponseDto u : uList) System.out.println(u);
                model.addAttribute("uList", uList);
                return "/company/company-main";
            }
        }
        return "main";
    }
    //평점 높은 회사 리스트
    void getHighRatingCompanyList(Model model) {
        List<CompanyResponseDto> cList = companyService.getHighRatingCompanyList();
        //for(CompanyResponseDto c : cList) System.out.println(c);
        model.addAttribute("cList", cList);
    }
    //채용임박 공고 리스트
    void getFastDeadLineList(Model model){
        List<CompanyResponseDto> eList = companyService.getFastDeadLineList();
        //(CompanyResponseDto e : eList) System.out.println(e);
        model.addAttribute("eList", eList);
    }
}
