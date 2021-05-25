package com.team.NewLearn.controller.mail;

import com.team.NewLearn.dto.member.MemberDTO;
import com.team.NewLearn.service.mail.MailService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class MailController {
    private final MailService mailService;

    @GetMapping("/pwFind")
    public String dispMail() {

        return "login/pwFind";
    }

    @PostMapping("/pwFind")
    public String execMail(MemberDTO memberDTO) {

        mailService.checkId(memberDTO);
        return "redirect:/main";
    }
}