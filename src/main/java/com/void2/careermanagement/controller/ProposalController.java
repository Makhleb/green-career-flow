package com.void2.careermanagement.controller;

import com.void2.careermanagement.dto.CompanyDto;
import com.void2.careermanagement.dto.UserDto;
import com.void2.careermanagement.dto.response.ProposalResponseDto;
import com.void2.careermanagement.service.ProposalService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

/**
 * Created on 2024-12-05 by 최윤서
 */
@Controller
@RequestMapping("/mypage")
public class ProposalController {

    private final ProposalService proposalService;

    public ProposalController(ProposalService proposalService) {
        this.proposalService = proposalService;
    }

    @GetMapping("/proposal")
    public String proposal(HttpSession session, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userType = session.getAttribute("userType").toString();
        String returnUrl = "";
        Object sessionUser = session.getAttribute("user");
        if(userType.equals("U")) {
            UserDto user = (UserDto) sessionUser;
            String userId = user.getUserId(); // UserDto 객체의 userId 필드 접근
            List<ProposalResponseDto> plist = proposalService.getProposalListById(userId);
            model.addAttribute("plist", plist);
            returnUrl = "/mypage/user-proposal";
        } else if (userType.equals("C")) {
            CompanyDto user = (CompanyDto) sessionUser;
            String companyId = user.getCompanyId();
            returnUrl = "/mypage/company-proposal";
        }
        return returnUrl;

    }

    @GetMapping("/proposal_detail/{proposalNo}")
    public String detail(HttpSession session, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userType = session.getAttribute("userType").toString();
        String returnUrl = "";
        Object sessionUser = session.getAttribute("user");
        if(userType.equals("U")) {
            UserDto user = (UserDto) sessionUser;
            String userId = user.getUserId(); // UserDto 객체의 userId 필드 접근
            ProposalResponseDto proposal = proposalService.getProposalById(userId);
            model.addAttribute("proposal", proposal);
            returnUrl = "/mypage/user-proposal-detail";
        } else if (userType.equals("C")) {
            CompanyDto user = (CompanyDto) sessionUser;
            String companyId = user.getCompanyId();


            returnUrl = "/mypage/company-proposal-detail";
        }
        return returnUrl;
    }

}
