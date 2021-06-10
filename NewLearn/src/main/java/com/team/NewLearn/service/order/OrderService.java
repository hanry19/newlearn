package com.team.NewLearn.service.order;

import com.team.NewLearn.dto.order.OrderDTO;

public interface OrderService {

    // 주문 요청
    void insertOrder(OrderDTO orderDTO);

}
