package com.team.NewLearn.service.cart;

import com.team.NewLearn.dto.cart.CartDTO;
import com.team.NewLearn.dto.cart.CartList;
import com.team.NewLearn.mapper.cart.CartMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{

    private final CartMapper cartMapper;

    @Override
    public List<CartList> getCartList(int memberId) {
        return cartMapper.selectCartList(memberId);
    }

    @Override
    public void deleteCartAll(int memberId) {
        cartMapper.deleteCartAll(memberId);
    }

    @Override
    public int deleteCart(CartDTO cartDTO){
        return cartMapper.deleteCart(cartDTO);
    }

    @Override
    public int countLecture(CartDTO cartDTO) {
        return cartMapper.countLecture(cartDTO);
    }

    @Override
    public int insertLecture(CartDTO cartDTO) {
        return cartMapper.insertLecture(cartDTO);
    }


}
