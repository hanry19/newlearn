package com.team.NewLearn.controller.community;


import com.team.NewLearn.dto.community.CommunityDTO;
import com.team.NewLearn.dto.paging.Criteria;
import com.team.NewLearn.dto.paging.PageDTO;
import com.team.NewLearn.service.community.StudyBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/community/study")
public class StudyBoardController {


    private final StudyBoardService studyBoardService;


    @GetMapping({"","/"})
    private String studyBoardList(Criteria cri, Model model) {
        List<CommunityDTO> communityDTOS = new ArrayList<>();

        communityDTOS = studyBoardService.getStudyBoardList(cri);

        model.addAttribute("communityDTOS", communityDTOS);
        model.addAttribute("pageMaker", new PageDTO(cri, studyBoardService.getTotal(cri)));

        return "community/freeList";
    }

    @GetMapping("/detail/{id}")
    private String boardDetail(@PathVariable("id") int id, Model model) {
        model.addAttribute("detail", studyBoardService.boardDetail(id));


            return "fileBoard/detail";
    }

    @PostMapping("/update/{id}")
    private String boardEdit(@PathVariable("id") int id, Model model) {
        model.addAttribute("detail", studyBoardService.boardDetail(id));
        return "fileBoard/update";
    }


    @PostMapping("/update")
    private String boardEditDone(CommunityDTO communityDTO) {

        studyBoardService.boardUpdate(communityDTO);

        int bno = communityDTO.getId();
        String id = Integer.toString(bno);

        return "redirect:/detail/{id}";
    }

    @PostMapping("/delete/{id}")
    private String fileDelete(@PathVariable("id") int id) {
        studyBoardService.boardDelete(id);

        return "redirect:/";
    }

    @GetMapping("/write")
    private String fileWrite(@ModelAttribute CommunityDTO communityDTO) {
        return "fileBoard/insert";
    }


    @PostMapping("/write")
    private String fileBoardInsertProc(@ModelAttribute CommunityDTO communityDTO) throws IllegalStateException, IOException, Exception {

            studyBoardService.boardInsert(communityDTO);

        return "forward:/"; //객체 재사용
    }




}