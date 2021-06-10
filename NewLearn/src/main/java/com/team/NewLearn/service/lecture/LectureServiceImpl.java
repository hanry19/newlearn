package com.team.NewLearn.service.lecture;

import com.team.NewLearn.dto.lecture.AttachFileDTO;
import com.team.NewLearn.dto.lecture.LectureDTO;
import com.team.NewLearn.dto.lectureunit.LectureUnitDTO;
import com.team.NewLearn.mapper.lecture.LectureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectureServiceImpl implements LectureService{

    @Autowired
    LectureMapper mapper;

    // 강의 페이지에서 Lecture list를 가져옴.
    @Override
    public List<LectureDTO> getLectureList() {
        return mapper.getLectureList();
    }

    // 개별 강의 페이지에 정보를 가져옴.
    @Override
    public LectureDTO getLecture(int id) {
        return mapper.getLecture(id);
    }

    // 개별 강의 페이지에서 커리큘럼을 가져옴.
    @Override
    public List<LectureUnitDTO> getLectureUnit(int id) {
        return mapper.getLectureUnit(id);
    }

    //수현 06.02
    @Override
    public int addLecture(LectureDTO lectureDTO) {
        return mapper.addLecture(lectureDTO);
    }


    // 이하 메소드 미구현

    @Override
    public int updateLecture(LectureDTO lectureDTO) {
        return 0;
    }

    @Override
    public int deleteLecture(int id) {
        return 0;
    }

    @Override
    public int addLectureID(String class_id, String uuid) {
        return mapper.addLectureID(class_id,uuid);
    }

    @Override
    public int addFile(AttachFileDTO fileDTO) {
        return mapper.addFile(fileDTO);
    }
}
