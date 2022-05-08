package org.singledog.dogmall.oms.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.oms.mapper.OrderItemMapper;
import org.singledog.dogmall.oms.entity.OrderItemEntity;
import org.singledog.dogmall.oms.service.OrderItemService;

import java.util.List;

@Service("orderItemService")
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItemEntity> implements OrderItemService {

    @Autowired
    private OrderItemMapper mapper;

    @Override
    public Response<List<OrderItemEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<OrderItemEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}