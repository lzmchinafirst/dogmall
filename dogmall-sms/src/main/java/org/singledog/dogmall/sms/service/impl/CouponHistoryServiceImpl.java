package org.singledog.dogmall.sms.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.sms.mapper.CouponHistoryMapper;
import org.singledog.dogmall.sms.entity.CouponHistoryEntity;
import org.singledog.dogmall.sms.service.CouponHistoryService;

import java.util.List;

@Service("couponHistoryService")
public class CouponHistoryServiceImpl extends ServiceImpl<CouponHistoryMapper, CouponHistoryEntity> implements CouponHistoryService {

    @Autowired
    private CouponHistoryMapper mapper;

    @Override
    public Response<List<CouponHistoryEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<CouponHistoryEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}