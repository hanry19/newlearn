package com.team.NewLearn.service.lecture;

import com.amazonaws.services.s3.model.ObjectMetadata;
import com.team.NewLearn.dto.lecture.AttachFileDTO;
import com.team.NewLearn.dto.lectureunit.LectureUnitDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface VideoService {
    void uploadLectureUnit(InputStream inputStream, ObjectMetadata objectMetadata, String fileName);

    String getVideoUrl(String fileName);

    LectureUnitDTO getLectureUnit(int id);

    public void uploadVideo(MultipartFile file,int id);

    int checkUnit(int id);
}

