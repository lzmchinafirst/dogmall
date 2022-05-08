package org.singledog.dogmall.wms.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.wms.mapper.WareOrderBillDetailMapper;
import org.singledog.dogmall.wms.entity.WareOrderBillDetailEntity;
import org.singledog.dogmall.wms.service.WareOrderBillDetailService;

import java.util.List;

@Service("wareOrderBillDetailService")
public class WareOrderBillDetailServiceImpl extends ServiceImpl<WareOrderBillDetailMapper, WareOrderBillDetailEntity> implements WareOrderBillDetailService {

    @Autowired
    private WareOrderBillDetailMapper mapper;

    @Override
    public Response<List<WareOrderBillDetailEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<WareOrderBillDetailEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}