package org.singledog.dogmail.pms.service.impl;

import org.singledog.dogmail.core.request.BaseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmail.pms.mapper.SpuMapper;
import org.singledog.dogmail.pms.entity.SpuEntity;
import org.singledog.dogmail.pms.service.SpuService;

import java.util.List;


@Service("spuService")
public class SpuServiceImpl extends ServiceImpl<SpuMapper, SpuEntity> implements SpuService {

    private SpuMapper spuMapper;

    @Autowired
    public SpuServiceImpl(SpuMapper spuMapper) {
        this.spuMapper = spuMapper;
    }

    @Override
    public List<SpuEntity> queryPage(BaseRequest request) {
        return request.query(spuMapper);
    }
}