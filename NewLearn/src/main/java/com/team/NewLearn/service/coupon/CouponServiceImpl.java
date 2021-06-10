package com.team.NewLearn.service.coupon;


import com.team.NewLearn.mapper.coupon.CouponMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService{

    private final CouponMapper couponMapper;

    @Override
    public int selectCoupon(String name) {
        int discount = couponMapper.selectCoupon(name);
        return discount;
    }

    @Override
    public int countCoupon(String couponCode) {
        int count = couponMapper.countCoupon(couponCode);
        return count;
    }


}
