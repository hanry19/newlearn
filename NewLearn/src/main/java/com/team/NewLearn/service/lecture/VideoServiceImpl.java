package com.team.NewLearn.service.lecture;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.team.NewLearn.dto.lecture.AttachFileDTO;
import com.team.NewLearn.dto.lectureunit.LectureUnitDTO;
import com.team.NewLearn.dto.lectureunit.S3Component;
import com.team.NewLearn.mapper.lecture.VideoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import static com.team.NewLearn.util.VideoTimeCut.media_player_time;

@Service
@RequiredArgsConstructor
public class VideoServiceImpl implements VideoService {

    private final AmazonS3Client amazonS3Client;
    private final S3Component s3Component;

    @Autowired
    VideoMapper videoMapper;

    @Override
    public void uploadLectureUnit(InputStream inputStream, ObjectMetadata objectMetadata, String fileName) {
        amazonS3Client.putObject(new PutObjectRequest(s3Component.getBucket(), fileName, inputStream, objectMetadata).withCannedAcl(CannedAccessControlList.PublicRead));
    }

    @Override
    public String getVideoUrl(String fileName) {
        return String.valueOf(amazonS3Client.getUrl(s3Component.getBucket(), fileName));
    }

    @Override
    public LectureUnitDTO getLectureUnit(int id) {
        return videoMapper.getLectureUnit(id);
    }

    @Override
    public int checkUnit(int id) {
        return videoMapper.checkUnit(id);
    }

    @Override
    public void uploadVideo(MultipartFile file,int id) {
        String fileName = createFileName(file.getOriginalFilename());


        // 파일을 업로드할 특정 폴더 지정해주자.(동영상 길이 측정시 ffmpeg 설치 후 경로 지정 해주어야함.)
//        String a = file.getOriginalFilename();
//        String fullName = "/Users/junfe/Desktop/"+a;
//
//        String lectureLength = media_player_time(fullName);
//
//        System.out.println("fileName = " + fullName);
//        System.out.println("lectureLength = " + lectureLength);

        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType(file.getContentType());

        try (InputStream inputStream = file.getInputStream()) {
            uploadLectureUnit(inputStream, objectMetadata, fileName);
        } catch (IOException e) {
            throw new IllegalArgumentException(String.format("파일 변환 중 에러가 발생하였습니다 (%s)", file.getOriginalFilename()));
        }

        //DB에 개별 강의 정보 INSERT
        LectureUnitDTO unit = new LectureUnitDTO();
        unit.setId(id);
        unit.setFileName(fileName);
        unit.setTitle("TEST1");
        unit.setUrl(getVideoUrl(fileName));
        //unit.setLectureLength(lectureLength);
        videoMapper.addLectureUnit(unit);
    }

    private String createFileName(String originalFileName) {
        return UUID.randomUUID().toString().concat(getFileExtension(originalFileName));
    }

    private String getFileExtension(String fileName) {
        try {
            return fileName.substring(fileName.lastIndexOf("."));
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(String.format("잘못된 형식의 파일 (%s) 입니다", fileName));
        }
    }
}
