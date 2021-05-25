package com.team.NewLearn.controller.community;


import com.team.NewLearn.dto.community.CommunityDTO;
import com.team.NewLearn.dto.paging.Criteria;
import com.team.NewLearn.dto.paging.PageDTO;
import com.team.NewLearn.service.community.FreeBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/community/free")
public class FreeBoardController {


    private final FreeBoardService freeBoardService;

    @GetMapping({"","/"})
    private String freeBoardList(Criteria cri, Model model) {
        List<CommunityDTO> communityDTOS = new ArrayList<>();

        communityDTOS = freeBoardService.getFreeBoardList(cri);

        model.addAttribute("communityDTOS", communityDTOS);
        model.addAttribute("pageMaker", new PageDTO(cri, freeBoardService.getTotal(cri)));


        return "community/freeList";
    }


    @GetMapping("/detail/{id}")
    private String freeBoardDetail(@PathVariable("id") int id, Model model) {

        model.addAttribute("detail", freeBoardService.boardDetail(id));


            return "community/detail";
    }

    @PostMapping("/update/{id}")
    private String freeBoardUpdate(@PathVariable("id") int id, Model model) {
        model.addAttribute("detail", freeBoardService.boardDetail(id));
        return "community/update";
    }


    @PostMapping("/update")
    private String freeBoardUpdate(CommunityDTO communityDTO) {

        freeBoardService.boardUpdate(communityDTO);

        int bno = communityDTO.getId();
        String id = Integer.toString(bno);

        return "redirect:/community/free/detail/"+ id;
    }

    @PostMapping("/delete/{id}")
    private String fileDelete(@PathVariable("id") int id) {
        freeBoardService.boardDelete(id);

        return "redirect:/";
    }

    @GetMapping("/write")
    private String fileWrite(@ModelAttribute CommunityDTO communityDTO) {
        return "community/insert";
    }


    @PostMapping("/write")
    private String fileBoardInsertProc(@ModelAttribute CommunityDTO communityDTO) throws IllegalStateException, IOException, Exception {

            freeBoardService.boardInsert(communityDTO);

        return "forward:/"; //객체 재사용
    }




}