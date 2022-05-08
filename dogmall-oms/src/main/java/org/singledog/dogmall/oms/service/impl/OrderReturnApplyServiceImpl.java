package org.singledog.dogmall.oms.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.oms.mapper.OrderReturnApplyMapper;
import org.singledog.dogmall.oms.entity.OrderReturnApplyEntity;
import org.singledog.dogmall.oms.service.OrderReturnApplyService;

import java.util.List;

@Service("orderReturnApplyService")
public class OrderReturnApplyServiceImpl extends ServiceImpl<OrderReturnApplyMapper, OrderReturnApplyEntity> implements OrderReturnApplyService {

    @Autowired
    private OrderReturnApplyMapper mapper;

    @Override
    public Response<List<OrderReturnApplyEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<OrderReturnApplyEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}