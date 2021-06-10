package com.team.NewLearn.controller.lecture;

import com.team.NewLearn.dto.lecture.AttachFileDTO;
import com.team.NewLearn.dto.lecture.LectureDTO;
import com.team.NewLearn.service.lecture.LectureService;
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
public class LectureController {

    @Autowired
    LectureService service;

    String uuid;

    @RequestMapping("/lecturelist")
    public String goToList(Model model){
        model.addAttribute("lectureDTOs",service.getLectureList());
        return "lecture/list";
    }

    @GetMapping("/detail/{id}")
    public String goToDetail(Model model,@PathVariable("id") int id){
        model.addAttribute("lectureDTO",service.getLecture(id));
        model.addAttribute("lectureUnitDTOs", service.getLectureUnit(id));
        return "lecture/detail";
    }

    @GetMapping("/goToAdd")
    public String gotoAdd(LectureDTO lectureDTO){
        return "lecture/add";
    }

    @PostMapping("/add")
    public String addClass(LectureDTO lectureDTO){
        System.out.println(lectureDTO);
        service.addLecture(lectureDTO);
        service.addLectureID(String.valueOf(lectureDTO.getId()),uuid);
        return "redirect:/detail/"+ lectureDTO.getId();
    }

    private String getUuid(String uuid){
        return this.uuid = uuid;
    }

    // Get방식으로 첨부파일을 업로드하는 페이지 맵핑
    @GetMapping("/uploadAjax")
    public void uploadAjax() {
        System.out.println("upload ajax");
    }

    // 서버에서 파일 자체가 이미지인지 한번 더 확인
    private boolean checkImageType(File file) {
        try {
            String contentType = Files.probeContentType(file.toPath());
            return contentType.startsWith("image");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    //uploadAjax.html에서 업로드 버튼 클릭 시 맵핑
    @PostMapping(value = "/uploadAjaxAction", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity<List<AttachFileDTO>> uploadAjaxPost(MultipartFile[] uploadFile) {

        List<AttachFileDTO> list = new ArrayList<>();
        String uploadFolder = "E:\\NewLearn\\NewLearnFinal\\NewLearn\\src\\main\\resources\\static\\img\\thumbnail\\"; //파일을 저장할 폴더 경로

        // getFolder()를 이용하여 파일 업로드 할 폴더 생성
        File uploadPath = new File(uploadFolder);

        if (uploadPath.exists() == false) {
            uploadPath.mkdirs(); // 해당 폴더가 없으면 생성하기
        }

        for (MultipartFile multipartFile : uploadFile) { //가져온 파일을 하나씩 처리

            AttachFileDTO attachDTO = new AttachFileDTO();

            String uploadFileName = multipartFile.getOriginalFilename(); //클라이언트가 올린 원래의 파일 이름을 저장

            uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1); //파일명을 수정하여 저장
            System.out.println("only file name: " + uploadFileName);
            attachDTO.setFileName(uploadFileName);

            UUID uuid = UUID.randomUUID(); // 중복방지를 위한 UUID 적용
            uploadFileName = uuid.toString() + "_" + uploadFileName;

            try {

                File saveFile = new File(uploadPath, uploadFileName);
                multipartFile.transferTo(saveFile); //파일 업로드 수행

                attachDTO.setUuid(uuid.toString());

                // 이미지 파일인지 확인
                if (checkImageType(saveFile)) {

                    attachDTO.setImage(true);

                    FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));
                    Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 228, 149);
                    thumbnail.close();
                }

                //해당 파일 DB에 저장
                System.out.println(attachDTO);
                service.addFile(attachDTO);
                getUuid(attachDTO.getUuid());

                list.add(attachDTO);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ResponseEntity<>(list, HttpStatus.OK); //JSON데이터를 반환
    }

    //섬네일 이미지 보여주기
    @GetMapping("/display")
    @ResponseBody
    public ResponseEntity<byte[]> getFile(String fileName) {
        System.out.println("fileName: " + fileName);

        File file = new File("E:\\NewLearn\\NewLearnFinal\\NewLearn\\src\\main\\resources\\static\\img\\thumbnail\\" + fileName);
        System.out.println("file: " + file);

        ResponseEntity<byte[]> result = null;

        try {
            HttpHeaders header = new HttpHeaders();
            header.add("Content-Type", Files.probeContentType(file.toPath()));
            result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file),header, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
