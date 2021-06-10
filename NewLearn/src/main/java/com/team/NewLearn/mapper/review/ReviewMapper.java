package com.team.NewLearn.mapper.review;

import com.team.NewLearn.dto.review.ReviewDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {

    //강의별 후기 갯수
    public int countReview(int lectureId);

    //강의별 후기 리스트
    public List<ReviewDTO> selectReviewList(int lectureId);

    //후기 입력
    public int insertReview(ReviewDTO review);

    //후기 업데이트
    public int updateReview(ReviewDTO review);

    //후기 삭제
    public int deleteReview(int reviewId);
}
