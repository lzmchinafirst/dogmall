package org.singledog.dogmall.pms.service.impl;

import org.singledog.dogmall.core.request.BaseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.pms.mapper.SpuDescMapper;
import org.singledog.dogmall.pms.entity.SpuDescEntity;
import org.singledog.dogmall.pms.service.SpuDescService;

import java.util.List;


@Service("spuDescService")
public class SpuDescServiceImpl extends ServiceImpl<SpuDescMapper, SpuDescEntity> implements SpuDescService {

    private SpuDescMapper spuDescMapper;

    @Autowired
    public SpuDescServiceImpl(SpuDescMapper spuDescMapper) {
        this.spuDescMapper = spuDescMapper;
    }

    @Override
    public List<SpuDescEntity> queryPage(BaseRequest request) {
        List<SpuDescEntity> spuDescEntities = request.query(spuDescMapper);
        return spuDescEntities;
    }
}