package com.team.NewLearn.service.cart;

import com.team.NewLearn.dto.cart.CartDTO;
import com.team.NewLearn.dto.cart.CartList;

import java.util.List;

public interface CartService {


    List<CartList> getCartList(int memberId);

    void deleteCartAll(int memberId);

    int deleteCart(CartDTO cartDTO);

    public int countLecture(CartDTO cartDTO);

    public int insertLecture(CartDTO cartDTO);


}
