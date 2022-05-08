package org.singledog.dogmall.sms.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.sms.mapper.SkuBoundsMapper;
import org.singledog.dogmall.sms.entity.SkuBoundsEntity;
import org.singledog.dogmall.sms.service.SkuBoundsService;

import java.util.List;

@Service("skuBoundsService")
public class SkuBoundsServiceImpl extends ServiceImpl<SkuBoundsMapper, SkuBoundsEntity> implements SkuBoundsService {

    @Autowired
    private SkuBoundsMapper mapper;

    @Override
    public Response<List<SkuBoundsEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<SkuBoundsEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}