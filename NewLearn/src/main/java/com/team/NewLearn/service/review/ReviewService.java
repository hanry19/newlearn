package com.team.NewLearn.service.review;

import com.team.NewLearn.dto.review.ReviewDTO;
import com.team.NewLearn.mapper.review.ReviewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewMapper reviewMapper;

    //강의별 후기 갯수
    public int countReview(int lectureId){
        return reviewMapper.countReview(lectureId);
    }

    //후기 등록
    public int insertReview(ReviewDTO review) {
        return reviewMapper.insertReview(review);
    }

    //강의별 후기 리스트
    public List<ReviewDTO> selectReviewList(int lectureId){
        return reviewMapper.selectReviewList(lectureId);
    }

    //후기 업데이트
    public int updateReview(ReviewDTO review){
        return reviewMapper.updateReview(review);
    }

    //후기 삭제
    public int deleteReview(int reviewId){
        return reviewMapper.deleteReview(reviewId);
    }
}
