package org.singledog.dogmall.sms.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.sms.mapper.HomeAdvMapper;
import org.singledog.dogmall.sms.entity.HomeAdvEntity;
import org.singledog.dogmall.sms.service.HomeAdvService;

import java.util.List;

@Service("homeAdvService")
public class HomeAdvServiceImpl extends ServiceImpl<HomeAdvMapper, HomeAdvEntity> implements HomeAdvService {

    @Autowired
    private HomeAdvMapper mapper;

    @Override
    public Response<List<HomeAdvEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<HomeAdvEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}