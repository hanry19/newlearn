package com.team.NewLearn.dto.cart;

import com.team.NewLearn.dto.lecture.LectureDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("CartList")
public class CartList {

    private CartDTO cart;
    private LectureDTO lecture;

}
