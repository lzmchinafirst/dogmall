package org.singledog.dogmall.wms.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.wms.mapper.PurchaseMapper;
import org.singledog.dogmall.wms.entity.PurchaseEntity;
import org.singledog.dogmall.wms.service.PurchaseService;

import java.util.List;

@Service("purchaseService")
public class PurchaseServiceImpl extends ServiceImpl<PurchaseMapper, PurchaseEntity> implements PurchaseService {

    @Autowired
    private PurchaseMapper mapper;

    @Override
    public Response<List<PurchaseEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<PurchaseEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}