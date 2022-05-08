package org.singledog.dogmall.wms.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.wms.mapper.WareMapper;
import org.singledog.dogmall.wms.entity.WareEntity;
import org.singledog.dogmall.wms.service.WareService;

import java.util.List;

@Service("wareService")
public class WareServiceImpl extends ServiceImpl<WareMapper, WareEntity> implements WareService {

    @Autowired
    private WareMapper mapper;

    @Override
    public Response<List<WareEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<WareEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}