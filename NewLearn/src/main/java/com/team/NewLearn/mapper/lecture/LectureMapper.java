package com.team.NewLearn.mapper.lecture;

import com.team.NewLearn.dto.lecture.AttachFileDTO;
import com.team.NewLearn.dto.lecture.LectureDTO;
import com.team.NewLearn.dto.lectureunit.LectureUnitDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LectureMapper {
    List<LectureDTO> getLectureList();
//    List<AttachFileDTO> getFile(int id);
    LectureDTO getLecture(int id);

    List<LectureUnitDTO> getLectureUnit(int id);

    int addLecture(LectureDTO lectureDTO);
    int updateLecture(LectureDTO lectureDTO);
    int deleteLecture(int id);
    int addFile(AttachFileDTO fileDTO);
    int addLectureID(String class_id,String uuid);
}
