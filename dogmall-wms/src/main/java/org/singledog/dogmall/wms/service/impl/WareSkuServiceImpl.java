package org.singledog.dogmall.wms.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.wms.mapper.WareSkuMapper;
import org.singledog.dogmall.wms.entity.WareSkuEntity;
import org.singledog.dogmall.wms.service.WareSkuService;

import java.util.List;

@Service("wareSkuService")
public class WareSkuServiceImpl extends ServiceImpl<WareSkuMapper, WareSkuEntity> implements WareSkuService {

    @Autowired
    private WareSkuMapper mapper;

    @Override
    public Response<List<WareSkuEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<WareSkuEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}