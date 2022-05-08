package org.singledog.dogmall.sms.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.sms.mapper.CouponMapper;
import org.singledog.dogmall.sms.entity.CouponEntity;
import org.singledog.dogmall.sms.service.CouponService;

import java.util.List;

@Service("couponService")
public class CouponServiceImpl extends ServiceImpl<CouponMapper, CouponEntity> implements CouponService {

    @Autowired
    private CouponMapper mapper;

    @Override
    public Response<List<CouponEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<CouponEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}