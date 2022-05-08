package org.singledog.dogmall.oms.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.oms.mapper.OrderSettingMapper;
import org.singledog.dogmall.oms.entity.OrderSettingEntity;
import org.singledog.dogmall.oms.service.OrderSettingService;

import java.util.List;

@Service("orderSettingService")
public class OrderSettingServiceImpl extends ServiceImpl<OrderSettingMapper, OrderSettingEntity> implements OrderSettingService {

    @Autowired
    private OrderSettingMapper mapper;

    @Override
    public Response<List<OrderSettingEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<OrderSettingEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}