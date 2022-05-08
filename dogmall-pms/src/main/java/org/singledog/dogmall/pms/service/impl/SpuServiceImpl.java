package org.singledog.dogmall.pms.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.pms.mapper.SpuMapper;
import org.singledog.dogmall.pms.entity.SpuEntity;
import org.singledog.dogmall.pms.service.SpuService;

import java.util.List;

@Service("spuService")
public class SpuServiceImpl extends ServiceImpl<SpuMapper, SpuEntity> implements SpuService {

    @Autowired
    private SpuMapper mapper;

    @Override
    public Response<List<SpuEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<SpuEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}