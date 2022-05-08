package org.singledog.dogmall.oms.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.oms.mapper.OrderReturnReasonMapper;
import org.singledog.dogmall.oms.entity.OrderReturnReasonEntity;
import org.singledog.dogmall.oms.service.OrderReturnReasonService;

import java.util.List;

@Service("orderReturnReasonService")
public class OrderReturnReasonServiceImpl extends ServiceImpl<OrderReturnReasonMapper, OrderReturnReasonEntity> implements OrderReturnReasonService {

    @Autowired
    private OrderReturnReasonMapper mapper;

    @Override
    public Response<List<OrderReturnReasonEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<OrderReturnReasonEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}