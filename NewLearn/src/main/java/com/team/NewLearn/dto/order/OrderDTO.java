package com.team.NewLearn.dto.order;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("orderDTO")
public class OrderDTO {

    private int id;
    private String orderId;
    private int memberId;
    private int lectureId;
    private String orderDate;
    private String name;
    private String tel;
    private String email;
}
