package com.team.NewLearn.dto.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
@Alias("cartDTO")
public class CartDTO {

    private int id;
    private int memberId;
    private int lectureId;

}
