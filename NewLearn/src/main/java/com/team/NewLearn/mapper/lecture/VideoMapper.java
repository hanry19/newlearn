package com.team.NewLearn.mapper.lecture;

import com.team.NewLearn.dto.lecture.AttachFileDTO;
import com.team.NewLearn.dto.lectureunit.LectureUnitDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VideoMapper {
    void addLectureUnit(LectureUnitDTO unit);
    LectureUnitDTO getLectureUnit(int id);
    int checkUnit(int id);
}
