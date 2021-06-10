package com.team.NewLearn.controller.community;


import com.team.NewLearn.dto.community.CommunityDTO;
import com.team.NewLearn.dto.paging.Criteria;
import com.team.NewLearn.dto.paging.PageDTO;
import com.team.NewLearn.service.community.FreeBoardService;
import com.team.NewLearn.service.community.StudyBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/community")
public class CommunityController {


    private final FreeBoardService freeBoardService;
    private final StudyBoardService studyBoardService;

    // 자유게시판 리스트 조회
    @RequestMapping({"","/free","/"})
    private String freeBoardList(Criteria cri, Model model, Authentication auth) {
        List<CommunityDTO> communityDTOS = new ArrayList<>();


        communityDTOS = freeBoardService.getFreeBoardList(cri);


        model.addAttribute("communityDTOS", communityDTOS);
//        model.addAttribute("auth", auth.getName());
        model.addAttribute("pageMaker", new PageDTO(cri, freeBoardService.getTotal(cri)));


        return "community/communityList";
    }

    @RequestMapping("/study")
    private String studyBoardList(Criteria cri, Model model) {
        List<CommunityDTO> communityDTOS = new ArrayList<>();

        communityDTOS = studyBoardService.getStudyBoardList(cri);

        model.addAttribute("communityDTOS", communityDTOS);
        model.addAttribute("pageMaker", new PageDTO(cri, studyBoardService.getTotal(cri)));

        return "community/communityList";
    }



    // 자유게시판 리스트 상세 조회
    @GetMapping("/detail/{id}")
    private String freeBoardDetail(@PathVariable("id") int id, Model model, Authentication auth) {

        log.info("::::::::: board request test for authentication ::::::");

        freeBoardService.viewUpdate(id);
        log.info("조회수 증가 먹혓나 ? " + id);

        model.addAttribute("detail", freeBoardService.boardDetail(id));

            return "community/communityDetail";
    }


    // 자유게시판 리스트 수정페이지
    @GetMapping("/update/{id}")
    private String freeBoardUpdate(@PathVariable("id") int id, Model model) {
        log.info("수정할 id : " + id);
        model.addAttribute("detail", freeBoardService.boardDetail(id));

        return "community/communityUpdate";
    }

    // 자유게시판 리스트 수정 완료
    @PostMapping("/update")
    private String freeBoardUpdate(CommunityDTO communityDTO) {

        freeBoardService.boardUpdate(communityDTO);

        int bno = communityDTO.getId();
        String id = Integer.toString(bno);

        return "redirect:/community/detail/"+ id;
    }
    // 자유게시판 리스트 삭제
    @PostMapping("/delete/{id}")
    private String fileDelete(@PathVariable("id") int id) {
        freeBoardService.boardDelete(id);

        return "redirect:/";
    }

    // 자유게시판 리스트 글쓰기페이지 요청
    @GetMapping("/write")
    private String fileWrite(@ModelAttribute CommunityDTO communityDTO, Model model, Authentication auth) {
        log.info(":::::::::: 글쓰기 페이지 요청  ::::::::::::");


        model.addAttribute("auth", auth);
        log.info("auth  :: :"   + auth);


        return "community/newList";
    }

    // 자유게시판 리스트 글쓰기 완료
    @PostMapping("/write")
    private String fileBoardInsertProc(@ModelAttribute CommunityDTO communityDTO) throws IllegalStateException, IOException, Exception {

        log.info(":::::::::: 글쓰기 작성 전송  ::::::::::::");

        log.info("글쓰기 요청 전에 페이지 : " + communityDTO.getEmail());
        log.info("글쓰기 요청 전에 페이지 : " + communityDTO.getName());
        log.info("글쓰기 요청 전에 페이지 : " + communityDTO.getTypeName());
        log.info("글쓰기 요청 전에 페이지 : " + communityDTO.getTitle());
        log.info("글쓰기 요청 전에 페이지 : " + communityDTO.getContent());

            freeBoardService.boardInsert(communityDTO);

        return "forward:/community/free/";
    }




}