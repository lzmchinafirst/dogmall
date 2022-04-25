package org.singledog.dogmail.pms.service.impl;

import org.singledog.dogmail.core.request.BaseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmail.pms.mapper.SpuDescMapper;
import org.singledog.dogmail.pms.entity.SpuDescEntity;
import org.singledog.dogmail.pms.service.SpuDescService;

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