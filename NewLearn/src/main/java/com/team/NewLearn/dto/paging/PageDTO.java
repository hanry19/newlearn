package com.team.NewLearn.dto.paging;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class PageDTO {

    private int startPage, endPage;
    private boolean prev, next;

    private int total;
    private Criteria cri;
//    private int displayPageNum = 5; // 하단에 출력할 페이지 사이즈

    public PageDTO(Criteria cri, int total) {
        this.cri = cri;
        this.total = total;

        this.endPage = (int) (Math.ceil(cri.getPageNum() / (double) cri.getDisplayPageNum()) * cri.getDisplayPageNum());

        this.startPage = (endPage - cri.getDisplayPageNum()) + 1;
        if(startPage <= 0 ) startPage =1;

        this.prev = startPage > 1;
        int realEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount()));

        this.endPage = realEnd <= endPage ? realEnd : endPage;
        this.next = endPage < realEnd;

    }

}
