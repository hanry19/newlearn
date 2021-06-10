package com.team.NewLearn.controller.lecture;

import com.team.NewLearn.dto.lecture.AttachFileDTO;
import com.team.NewLearn.dto.lecture.LectureDTO;
import com.team.NewLearn.service.lecture.VideoService;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class VideoController {

    @Autowired
    VideoService videoService;

    @GetMapping("/goToAddUnit/{id}")
    public String gotoAddUnit(@PathVariable("id") int id,Model model){
        model.addAttribute("id",id);
        return "lecture/addLectureUnit";
    }

    @PostMapping("/api/v1/upload/{id}")
    public String uploadImage(@PathVariable("id")int id,@RequestParam("files") MultipartFile file) throws Exception { //multipart/form-data 요청을 받도록 컨트롤러 단에서 처리하는 로직
        System.out.println("FileUploadController!!!!!");
        videoService.uploadVideo(file,id);
        return "redirect:/detail/" + id;
    }

    @GetMapping("/unit/{id}/{originId}")
    public String goToDetailLecture(Model model,@PathVariable("id") int id,@PathVariable("originId") int originId){
        int count = videoService.checkUnit(id);
        if (count > 0 ) {
            model.addAttribute("unit",videoService.getLectureUnit(id));
        } else{
            model.addAttribute("unit",videoService.getLectureUnit(originId));
        }
        return "lecture/video";
    }
}
