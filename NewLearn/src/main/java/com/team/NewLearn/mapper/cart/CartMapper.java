package com.team.NewLearn.mapper.cart;

import com.team.NewLearn.dto.cart.CartDTO;
import com.team.NewLearn.dto.cart.CartList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {

    //장바구니 리스트 찾기(회원ID)
    public List<CartList> selectCartList(int memberId);

    // 카트 전체 삭제
    public void deleteCartAll(int memberId);

    //카트 부분 삭제
    public int deleteCart(CartDTO cart);

    //카트에 같은 강의 있는지 여부
    public int countLecture(CartDTO cartDTO);

    //카트에 강의 추가
    public int insertLecture(CartDTO cartDTO);
}
