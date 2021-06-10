package com.team.NewLearn.controller.review;

import com.team.NewLearn.dto.review.ReviewDTO;
import com.team.NewLearn.service.member.MemberService;
import com.team.NewLearn.service.review.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/review")
@RequiredArgsConstructor
@Log4j2
public class ReviewController {

    private String email = "";
    private int memberId;
    private final ReviewService reviewService;
    private final MemberService memberService;

    @RequestMapping("/list")
    @ResponseBody
    public List<ReviewDTO>  selectReviewList(@RequestParam int lectureId, Authentication auth){
        // 로그인한 정보 중 이름을 불러온다.
        this.email = auth.getName().toString();
        //email로 memberId 찾기.
        memberId = memberService.selectMemberId(email);
        log.info(auth.getDetails());
        System.out.println(memberId);

        List<ReviewDTO> reviewList = reviewService.selectReviewList(lectureId);
        return reviewList;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public int insertReview(@ModelAttribute ReviewDTO review){
        review.setMemberId(memberId);
        int result = reviewService.insertReview(review);
        return result;
    }

    @RequestMapping("/update")
    @ResponseBody
    public int updateReview(@ModelAttribute ReviewDTO review){
        int result = reviewService.updateReview(review);
        return result;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public int deleteReview(@RequestParam int id){
        int result = reviewService.deleteReview(id);
        return result;
    }
}
