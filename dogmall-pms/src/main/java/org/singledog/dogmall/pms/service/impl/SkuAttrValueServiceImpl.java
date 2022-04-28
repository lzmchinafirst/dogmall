package org.singledog.dogmall.pms.service.impl;

import org.singledog.dogmall.core.request.BaseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.pms.mapper.SkuAttrValueMapper;
import org.singledog.dogmall.pms.entity.SkuAttrValueEntity;
import org.singledog.dogmall.pms.service.SkuAttrValueService;

import java.util.List;


@Service("skuAttrValueService")
public class SkuAttrValueServiceImpl extends ServiceImpl<SkuAttrValueMapper, SkuAttrValueEntity> implements SkuAttrValueService {

    private SkuAttrValueMapper skuAttrValueMapper;

    @Autowired
    public SkuAttrValueServiceImpl(SkuAttrValueMapper skuAttrValueMapper) {
        this.skuAttrValueMapper = skuAttrValueMapper;
    }

    @Override
    public List<SkuAttrValueEntity> query(BaseRequest request) {
        return request.query(skuAttrValueMapper);
    }
}