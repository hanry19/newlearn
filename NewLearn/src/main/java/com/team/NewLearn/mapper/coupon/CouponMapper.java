package com.team.NewLearn.mapper.coupon;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CouponMapper {

    public int selectCoupon(String couponCode);

    public int countCoupon(String couponCode);

}
