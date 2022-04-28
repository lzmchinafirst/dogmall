package org.singledog.dogmall.pms.service.impl;

import org.singledog.dogmall.core.request.BaseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.pms.mapper.SkuMapper;
import org.singledog.dogmall.pms.entity.SkuEntity;
import org.singledog.dogmall.pms.service.SkuService;

import java.util.List;


@Service("skuService")
public class SkuServiceImpl extends ServiceImpl<SkuMapper, SkuEntity> implements SkuService {

    private SkuMapper skuMapper;

    @Autowired
    public SkuServiceImpl(SkuMapper skuMapper) {
        this.skuMapper = skuMapper;
    }

    @Override
    public List<SkuEntity> query(BaseRequest request) {
        return request.query(skuMapper);
    }
}