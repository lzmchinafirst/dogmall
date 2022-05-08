package org.singledog.dogmall.sms.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.sms.mapper.SeckillPromotionMapper;
import org.singledog.dogmall.sms.entity.SeckillPromotionEntity;
import org.singledog.dogmall.sms.service.SeckillPromotionService;

import java.util.List;

@Service("seckillPromotionService")
public class SeckillPromotionServiceImpl extends ServiceImpl<SeckillPromotionMapper, SeckillPromotionEntity> implements SeckillPromotionService {

    @Autowired
    private SeckillPromotionMapper mapper;

    @Override
    public Response<List<SeckillPromotionEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<SeckillPromotionEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}