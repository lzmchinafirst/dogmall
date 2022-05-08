package org.singledog.dogmall.sms.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.sms.mapper.CouponSpuMapper;
import org.singledog.dogmall.sms.entity.CouponSpuEntity;
import org.singledog.dogmall.sms.service.CouponSpuService;

import java.util.List;

@Service("couponSpuService")
public class CouponSpuServiceImpl extends ServiceImpl<CouponSpuMapper, CouponSpuEntity> implements CouponSpuService {

    @Autowired
    private CouponSpuMapper mapper;

    @Override
    public Response<List<CouponSpuEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<CouponSpuEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}