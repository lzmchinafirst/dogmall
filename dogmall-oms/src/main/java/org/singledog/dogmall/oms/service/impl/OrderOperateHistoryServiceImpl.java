package org.singledog.dogmall.oms.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.oms.mapper.OrderOperateHistoryMapper;
import org.singledog.dogmall.oms.entity.OrderOperateHistoryEntity;
import org.singledog.dogmall.oms.service.OrderOperateHistoryService;

import java.util.List;

@Service("orderOperateHistoryService")
public class OrderOperateHistoryServiceImpl extends ServiceImpl<OrderOperateHistoryMapper, OrderOperateHistoryEntity> implements OrderOperateHistoryService {

    @Autowired
    private OrderOperateHistoryMapper mapper;

    @Override
    public Response<List<OrderOperateHistoryEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<OrderOperateHistoryEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}