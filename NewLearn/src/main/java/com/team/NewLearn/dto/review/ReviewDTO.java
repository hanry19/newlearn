package com.team.NewLearn.dto.review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("reviewDTO")
public class ReviewDTO {

    private int id;
    private int lectureId;
    private int memberId;
    private String content;
    private String regDate;
    private String email;
}
