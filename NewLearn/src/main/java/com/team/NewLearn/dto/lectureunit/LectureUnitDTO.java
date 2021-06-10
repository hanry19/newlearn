package com.team.NewLearn.dto.lectureunit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("lectureUnitDTO")
public class LectureUnitDTO {
    int id;
    int lectureId;
    String title;
    String fileName; //저장되는 이름
    String url;
    String lectureLength;
    int order; // 얘는 뭐지?
}
