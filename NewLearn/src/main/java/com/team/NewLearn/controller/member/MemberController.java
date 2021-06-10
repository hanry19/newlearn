package com.team.NewLearn.controller.member;

import com.team.NewLearn.dto.member.MemberDTO;
import com.team.NewLearn.dto.paging.Criteria;
import com.team.NewLearn.dto.paging.PageDTO;
import com.team.NewLearn.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/mypage")
public class MemberController {

    private final MemberService memberService;

    // 회원 정보 조회
    @GetMapping("/select")
    public String selectAllMember(Model model, Authentication auth) {

        log.info("권한 디테일"+auth.getDetails());
        List<MemberDTO> memberDTOS = new ArrayList<>();

        if (auth.getAuthorities().toString().equals("[ROLE_ADMIN]")) {

            log.info("::::[ controller 관리자 ]:::: 전체회원 조회  :::::::::::: ");

            return "redirect:/admin/community";
        }else {

            memberDTOS = memberService.selectMember(auth.getName());

            model.addAttribute("result", memberDTOS);
            return "member/profile";
        }
    }

    // 회원 상세 조회
    @GetMapping("/detail/{id}")
    public String selectMemberDetail(@PathVariable int id, Model model) {
        log.info("::::::::::: 회원 상세조회  in controller ::::::::::::::");
        model.addAttribute("detail", memberService.selectDetailMember(id));
        return "member/memberDetail";
    }

    // 회원 정보 수정
    @GetMapping("/update/{id}")
    public String updateMember(@PathVariable int id, Model model) {

        log.info("::::::::::: 회원 정보 수정  in controller :::::::::::::::::");

        model.addAttribute("update", memberService.selectDetailMember(id));

        return "member/memberUpdate";
    }

    // 회원 정보 수정 완료
    @PostMapping("/update")
    public String updateMember(@ModelAttribute MemberDTO memberDTO) {

        log.info("::::::::::: 회원 정보 수정 완료 in controller  :::::::::::::::::::");

        memberService.memberUpdate(memberDTO);

        return "redirect:/mypage/select";
    }

    // 회원 탈퇴
    @PostMapping("/delete/{id}")
    public String deleteMember(@PathVariable int id) {

        log.info("::::::::::: 회원 탈퇴 ::::::::::::::::::::::::");
        memberService.memberDelete(id);

        return "redirect:/main";
    }



}
