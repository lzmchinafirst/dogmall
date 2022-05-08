package org.singledog.dogmall.wms.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.wms.mapper.PurchaseDetailMapper;
import org.singledog.dogmall.wms.entity.PurchaseDetailEntity;
import org.singledog.dogmall.wms.service.PurchaseDetailService;

import java.util.List;

@Service("purchaseDetailService")
public class PurchaseDetailServiceImpl extends ServiceImpl<PurchaseDetailMapper, PurchaseDetailEntity> implements PurchaseDetailService {

    @Autowired
    private PurchaseDetailMapper mapper;

    @Override
    public Response<List<PurchaseDetailEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<PurchaseDetailEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}