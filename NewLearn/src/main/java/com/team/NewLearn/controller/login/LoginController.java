package com.team.NewLearn.controller.login;

import com.team.NewLearn.dto.member.MemberDTO;
import com.team.NewLearn.service.login.SecurityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
@RequiredArgsConstructor
public class LoginController {

    private final SecurityService securityServiceMapper;


    //회원가입 GET
    @GetMapping("/sign-Up")
    private String join(@ModelAttribute MemberDTO memberDTO) {

        log.info(":::::::::::  회원가입  in controller ::::::::::::::::::");

        return "login/join";
    }
    //회원가입 Insert
    @PostMapping("/sign-Up")
    private String setInsertMember(@ModelAttribute MemberDTO memberDTO) throws Exception{
        log.info("::::::::::: 회원가입 전송 in controller ::::::::::::::::::");
        securityServiceMapper.memberSignUp(memberDTO);
        return "forward:/login";
    }

    //로그인 GET
    @RequestMapping("/login")
    private String login() {
        log.info(":::::::::::  로그인  in controller ::::::::::::::::::");
        return "login/login";
    }

    //로그인 에러페이지 이동
    @GetMapping("/login/login-error")
    private String error() {

        log.info(":::::::::::  로그인 에러페이지 in controller ::::::::::::::::::");

        return  "login/error";
    }



    //아이디 중복체크
    @PostMapping("/join/idCheck")
    @ResponseBody
    private String idCheck(@RequestParam String email) throws Exception{
        MemberDTO memberDTO = securityServiceMapper.selectMemberInfo(email);
        String canUse = memberDTO != null ? "" : "Y";
        return canUse;
    }


}
