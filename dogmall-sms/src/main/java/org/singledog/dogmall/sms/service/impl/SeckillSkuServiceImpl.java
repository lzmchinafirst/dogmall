package org.singledog.dogmall.sms.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.sms.mapper.SeckillSkuMapper;
import org.singledog.dogmall.sms.entity.SeckillSkuEntity;
import org.singledog.dogmall.sms.service.SeckillSkuService;

import java.util.List;

@Service("seckillSkuService")
public class SeckillSkuServiceImpl extends ServiceImpl<SeckillSkuMapper, SeckillSkuEntity> implements SeckillSkuService {

    @Autowired
    private SeckillSkuMapper mapper;

    @Override
    public Response<List<SeckillSkuEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<SeckillSkuEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}