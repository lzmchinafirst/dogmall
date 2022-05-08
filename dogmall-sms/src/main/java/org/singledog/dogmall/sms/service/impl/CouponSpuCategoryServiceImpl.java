package org.singledog.dogmall.sms.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.sms.mapper.CouponSpuCategoryMapper;
import org.singledog.dogmall.sms.entity.CouponSpuCategoryEntity;
import org.singledog.dogmall.sms.service.CouponSpuCategoryService;

import java.util.List;

@Service("couponSpuCategoryService")
public class CouponSpuCategoryServiceImpl extends ServiceImpl<CouponSpuCategoryMapper, CouponSpuCategoryEntity> implements CouponSpuCategoryService {

    @Autowired
    private CouponSpuCategoryMapper mapper;

    @Override
    public Response<List<CouponSpuCategoryEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<CouponSpuCategoryEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}