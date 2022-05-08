package org.singledog.dogmall.oms.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.oms.mapper.OrderMapper;
import org.singledog.dogmall.oms.entity.OrderEntity;
import org.singledog.dogmall.oms.service.OrderService;

import java.util.List;

@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderEntity> implements OrderService {

    @Autowired
    private OrderMapper mapper;

    @Override
    public Response<List<OrderEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<OrderEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}