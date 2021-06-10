package com.team.NewLearn.dto.lecture;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
@Alias("lectureDTO")
public class LectureDTO {

    int id;
    int categoryId;
    int memberId;
    String title;
    String content;
    int price;
    int buyCount;
    Date regDate;
    String sContent;

    String filename;
    String uploadpath;
    String uuid;
}
