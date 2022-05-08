package org.singledog.dogmall.wms.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.wms.mapper.WareOrderBillMapper;
import org.singledog.dogmall.wms.entity.WareOrderBillEntity;
import org.singledog.dogmall.wms.service.WareOrderBillService;

import java.util.List;

@Service("wareOrderBillService")
public class WareOrderBillServiceImpl extends ServiceImpl<WareOrderBillMapper, WareOrderBillEntity> implements WareOrderBillService {

    @Autowired
    private WareOrderBillMapper mapper;

    @Override
    public Response<List<WareOrderBillEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<WareOrderBillEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}