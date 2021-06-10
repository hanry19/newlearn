package com.team.NewLearn.controller.main;

import com.team.NewLearn.dto.member.MemberDTO;
import com.team.NewLearn.dto.paging.Criteria;
import com.team.NewLearn.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
public class MainController {

    private final MemberService memberService;

    @GetMapping("/main")
    public String selectAllMember(Model model, Authentication auth) {

        log.info("main 페이지 컨트롤러");

        if (auth != null) {

            model.addAttribute("result", memberService.selectMember(auth.getName()));
            model.addAttribute("auth", auth);

            return "main/index";
        } else {

            return "main/index";
        }
    }
}
