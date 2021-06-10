package com.team.NewLearn.mapper.order;


import com.team.NewLearn.dto.order.OrderDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    //주문 테이블 insert
    void insertOrder(OrderDTO orderDTO);

}
