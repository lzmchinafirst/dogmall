package org.singledog.dogmall.pms.service.impl;

import org.singledog.dogmall.core.request.BaseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.pms.mapper.SkuImagesMapper;
import org.singledog.dogmall.pms.entity.SkuImagesEntity;
import org.singledog.dogmall.pms.service.SkuImagesService;

import java.util.List;


@Service("skuImagesService")
public class SkuImagesServiceImpl extends ServiceImpl<SkuImagesMapper, SkuImagesEntity> implements SkuImagesService {

    private SkuImagesMapper skuImagesMapper;

    @Autowired
    public SkuImagesServiceImpl(SkuImagesMapper skuImagesMapper) {
        this.skuImagesMapper = skuImagesMapper;
    }

    @Override
    public List<SkuImagesEntity> query(BaseRequest request) {
        return request.query(skuImagesMapper);
    }
}