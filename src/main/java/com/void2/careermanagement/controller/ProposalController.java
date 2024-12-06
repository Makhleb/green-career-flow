package com.void2.careermanagement.controller;

import com.void2.careermanagement.dto.CompanyDto;
import com.void2.careermanagement.dto.ProposalDto;
import com.void2.careermanagement.dto.UserDto;
import com.void2.careermanagement.dto.response.ProposalResponseDto;
import com.void2.careermanagement.service.ProposalService;
import com.void2.careermanagement.util.SessionUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
        if(SessionUtil.sessionUserCheckRedirectLogin(session, request, response)) return null;
        String userType = session.getAttribute("userType").toString();
        String returnUrl = "";
        Object sessionUser = session.getAttribute("user");
        if(userType.equals("U")) {
            UserDto user = (UserDto) sessionUser;
            String userId = user.getUserId(); // UserDto 객체의 userId 필드 접근
            List<ProposalResponseDto> plist = proposalService.getProposalListByUserId(userId);
            model.addAttribute("plist", plist);
            returnUrl = "/mypage/user-proposal";
        } else if (userType.equals("C")) {
            CompanyDto user = (CompanyDto) sessionUser;
            String companyId = user.getCompanyId();
            List<ProposalResponseDto> plist = proposalService.getProposalListByCompanyId(companyId);
            model.addAttribute("plist", plist);
            returnUrl = "/mypage/company-proposal";
        }
        return returnUrl;

    }

    @GetMapping("/proposal_detail/{proposalNo}")
    public String detail(@PathVariable("proposalNo")int proposalNo, HttpSession session, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(SessionUtil.sessionUserCheckRedirectLogin(session, request, response)) return null;
        String userType = session.getAttribute("userType").toString();
        String returnUrl = "";
        Object sessionUser = session.getAttribute("user");
        if(userType.equals("U")) {
            UserDto user = (UserDto) sessionUser;
            String userId = user.getUserId(); // UserDto 객체의 userId 필드 접근

            proposalService.updateReadDate(proposalNo);

            ProposalResponseDto proposal = proposalService.getProposalByUserId(proposalNo);
            model.addAttribute("proposal", proposal);

            returnUrl = "/mypage/user-proposal-detail";
        } else if (userType.equals("C")) {
            CompanyDto user = (CompanyDto) sessionUser;
            String companyId = user.getCompanyId();
            ProposalResponseDto proposal = proposalService.getProposalByCompanyId(proposalNo);
            model.addAttribute("proposal", proposal);
            returnUrl = "/mypage/company-proposal-detail";
        }
        return returnUrl;
    }

    @RequestMapping("/proposal-registForm")
    public String registForm(){
        return "/mypage/company-proposal-regist";
    }
    @GetMapping("/proposal-registForm/{userId}")
    public String registForm(@PathVariable String userId, Model model){
        model.addAttribute("userId", userId);
        return "/mypage/company-proposal-regist";
    }

    @PostMapping("/regist")
    public String registProposal(ProposalDto proposalDto){
        int result = proposalService.registProposalByCompanyId(proposalDto);
        return "redirect:/mypage/proposal";
    }

}
