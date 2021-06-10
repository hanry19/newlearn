package com.team.NewLearn.controller.admin;

import com.team.NewLearn.dto.member.MemberDTO;
import com.team.NewLearn.dto.paging.Criteria;
import com.team.NewLearn.dto.paging.PageDTO;
import com.team.NewLearn.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Controller
@RequiredArgsConstructor
public class AdminController {

    private final MemberService memberService;


    // [회원] 전체 회원 조회
    @GetMapping("/admin/member")
    public String selectAllMember(Criteria cri, Model model, Authentication auth) {
        List<MemberDTO> memberDTOS = new ArrayList<>();

        log.info("::::[ controller 관리자 ]:::: 전체회원 조회  :::::::::::: ");

        memberDTOS = memberService.selectAllMember(cri);

        model.addAttribute("auth", auth);
        model.addAttribute("result", memberDTOS);
        model.addAttribute("pageMaker", new PageDTO(cri, memberService.getTotal()));

        return "admin/adminMember";
    }

    // [회원] 체크된 회원 삭제
    @PostMapping("/admin/member/delete")
    public String deleteMember(@RequestParam("delete") List<String> ids){

        log.info(" [관리자] 선택 회원 삭제 ::::::::::: ");
        if (ids != null) {
            for(String idStr : ids){
                int id = Integer.parseInt(idStr);
                memberService.memberDelete(id);
            }
        }
        return "redirect:/admin/member";
    }

    /////////////////////////////강의 시작//////////////////////////
    // [강의] 전체 강의 조회
    @GetMapping("/admin/lecture")
    public String selectAllLecture(Criteria cri, Model model, Authentication auth) {
        List<MemberDTO> memberDTOS = new ArrayList<>();

        log.info(" [관리자] 전체 강의 조회  :::::::::::: ");

//        강의 서비스로 바꿔야함
        memberDTOS = memberService.selectAllMember(cri);

        model.addAttribute("auth", auth);
        model.addAttribute("result", memberDTOS);
        model.addAttribute("pageMaker", new PageDTO(cri, memberService.getTotal()));

        return "admin/adminLecture";

    }
    // [강의] 체크된 강의 삭제
    @PostMapping("/admin/lecture/delete")
    public String deleteLecture(@RequestParam("delete") List<String> ids){

        log.info(" [관리자] 선택 강의 삭제  :::::::::::: ");
        if (ids != null) {
            for(String idStr : ids){
                int id = Integer.parseInt(idStr);
                memberService.memberDelete(id);
            }
        }
        return "redirect:/admin/lecture";
    }
    /////////////////////////////강의 끝 //////////////////////////

    /////////////////////////////커뮤니티 시작 //////////////////////////

    // [커뮤니티] 전체 회원 조회
    @GetMapping("/admin/community")
    public String selectAllCommunity(Criteria cri, Model model, Authentication auth) {
        List<MemberDTO> memberDTOS = new ArrayList<>();

        log.info("::::[ community controller 관리자 ]:::: 전체 커뮤니티 조회  :::::::::::: ");


        //        커뮤니티 서비스로 바꿔야함
        memberDTOS = memberService.selectAllMember(cri);


        model.addAttribute("auth", auth);
        model.addAttribute("result", memberDTOS);
        model.addAttribute("pageMaker", new PageDTO(cri, memberService.getTotal()));

        return "admin/adminCommunity";

    }

    // [커뮤니티] 체크된 회원 삭제
    @PostMapping("/admin/community/delete")
    public String deleteCommunity(@RequestParam("delete") List<String> ids){

        log.info(" [관리자] 선택 커뮤니티 삭제  :::::::::::: ");

        if (ids != null) {
            for(String idStr : ids){
                int id = Integer.parseInt(idStr);
                memberService.memberDelete(id);
            }
        }
        return "redirect:/admin/community";
    }

    /////////////////////////////커뮤니티 끝 //////////////////////////


}
