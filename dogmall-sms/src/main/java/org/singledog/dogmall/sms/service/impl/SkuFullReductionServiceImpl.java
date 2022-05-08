package org.singledog.dogmall.sms.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.sms.mapper.SkuFullReductionMapper;
import org.singledog.dogmall.sms.entity.SkuFullReductionEntity;
import org.singledog.dogmall.sms.service.SkuFullReductionService;

import java.util.List;

@Service("skuFullReductionService")
public class SkuFullReductionServiceImpl extends ServiceImpl<SkuFullReductionMapper, SkuFullReductionEntity> implements SkuFullReductionService {

    @Autowired
    private SkuFullReductionMapper mapper;

    @Override
    public Response<List<SkuFullReductionEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<SkuFullReductionEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}