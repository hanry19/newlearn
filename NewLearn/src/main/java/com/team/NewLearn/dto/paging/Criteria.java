package com.team.NewLearn.dto.paging;


import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Criteria {

    // 페이징을 위한 멤버 변수
    private int pageNum; // 지금 내가 보고 잇는 페이지 번호
    private int amount;  // 한 페이지에 보여줄 게시글 갯수
    private int displayPageNum;

    // 동적 검색을 위한 멤버 변수
    private String type;        // t, tx, tcw. cw. 이런 식으로 하려고 함 ==> 배열 필요
    private String keyword;

    // 페이징 시 첫 페이지 , 페이지 당 글 갯수 지정
    public Criteria() {
        this.pageNum = 1;
        this.amount = 10;
        this.displayPageNum = 5;
    }

    public Criteria(int pageNum, int amount, int displayPageNum) {
        this.pageNum = pageNum;
        this.amount = amount;
        this.displayPageNum = displayPageNum;
    }

    // mysql의 limit 구문에 사용 되는 메서드
    public int getPageStart(){
        return (pageNum-1) * amount;
    }

    // loop를 돌리 기 위해 배열이 필요하다.
    public String[] getTypeArr() {

        // string 배열이 null이 안나오게 하려고 빈 배열을 준다.
        return  type == null? new String[] {} : type.split("");

    }


}
