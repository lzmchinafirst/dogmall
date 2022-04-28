package org.singledog.dogmall.pms.service.impl;

import org.singledog.dogmall.core.request.BaseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.pms.mapper.SpuAttrValueMapper;
import org.singledog.dogmall.pms.entity.SpuAttrValueEntity;
import org.singledog.dogmall.pms.service.SpuAttrValueService;

import java.util.List;


@Service("spuAttrValueService")
public class SpuAttrValueServiceImpl extends ServiceImpl<SpuAttrValueMapper, SpuAttrValueEntity> implements SpuAttrValueService {

    private SpuAttrValueMapper spuDescMapper;

    @Autowired
    public SpuAttrValueServiceImpl(SpuAttrValueMapper spuDescMapper) {
        this.spuDescMapper = spuDescMapper;
    }

    @Override
    public List<SpuAttrValueEntity> queryPage(BaseRequest request) {
        return request.query(spuDescMapper);
    }
}