package com.team.NewLearn.service.order;


import com.team.NewLearn.dto.order.OrderDTO;
import com.team.NewLearn.mapper.order.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Calendar;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderMapper orderMapper;


    public void insertOrder(OrderDTO orderDTO){
        //orderId = 년월일_난수
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
        String ymd = ym +  new DecimalFormat("00").format(cal.get(Calendar.DATE));
        String subNum = "";

        for(int i = 1; i <= 6; i ++) {
            subNum += (int)(Math.random() * 10);
        }
        String orderId = ymd + "_" + subNum;
        orderDTO.setOrderId(orderId);

        orderMapper.insertOrder(orderDTO);
    }




}
