package com.void2.careermanagement.controller;

import com.void2.careermanagement.dto.request.ApplyRequestDto;
import com.void2.careermanagement.service.ApplyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2024-12-03 by 황승현
 */
@RestController
@RequestMapping("/api/apply")
public class ApplyApiController {
    private final ApplyService applyService;

    public ApplyApiController(ApplyService applyService) {
        this.applyService = applyService;
    }

    @PostMapping
    public int apply(@RequestBody ApplyRequestDto applyDto) {
        return applyService.insert(applyDto);
    }

    @PostMapping("/pass")
    public int pass(@RequestBody ApplyRequestDto applyDto) {
        System.out.println(applyDto);
        return applyService.updatePass(applyDto);
    }

}
