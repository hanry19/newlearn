package com.team.NewLearn.controller.order;

import com.team.NewLearn.dto.order.OrderDTO;
import com.team.NewLearn.service.cart.CartService;

import com.team.NewLearn.service.member.MemberService;
import com.team.NewLearn.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DecimalFormat;
import java.util.Calendar;

@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
@Log4j2
public class OrderController {

    private String email = "";
    private int memberId;
    private final OrderService orderService;
    private final CartService cartService;
    private final MemberService memberService;

    @PostMapping
    public String insertOrder(@ModelAttribute OrderDTO orderDTO, Authentication auth){

        email = auth.getName().toString();
        memberId = memberService.selectMemberId(email);
        log.info(":::::::::::주문하기 in controller ::::::::::::::::::");
        orderDTO.setMemberId(memberId);
        orderService.insertOrder(orderDTO);
        cartService.deleteCartAll(memberId);
        return "redirect:/main";
    }
}
