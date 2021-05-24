package com.team.NewLearn.controller.cart;

import com.team.NewLearn.dto.cart.CartDTO;
import com.team.NewLearn.dto.cart.CartList;
import com.team.NewLearn.service.cart.CartService;
import com.team.NewLearn.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
@Log4j2
public class CartController {

    private String email = "";
    private int memberId;
    private final CartService cartService;
    private final MemberService memberService;

    @GetMapping("/list")
    public String getCartList(Model model, Authentication auth) {

        // 로그인한 정보 중 이름을 불러온다.
        this.email = auth.getName().toString();
        //email로 memberId 찾기.
        memberId = memberService.selectMemberId(email);
        log.info(auth.getDetails());
        System.out.println(memberId);

        List<CartList> cartLists = cartService.getCartList(memberId);
        model.addAttribute("cartLists", cartLists);
        return "/cart/cart";
    }

    @ResponseBody
    @PostMapping("/delete")
    public int deleteCart(@RequestParam int cartId, CartDTO cartDTO){
        cartDTO.setMemberId(this.memberId);
        cartDTO.setId(cartId);
        log.info(":::::::::::장바구니 부분삭제 in controller ::::::::::::::::::");
        System.out.println(cartDTO);
        int result = cartService.deleteCart(cartDTO);
        return result;
    }
}
