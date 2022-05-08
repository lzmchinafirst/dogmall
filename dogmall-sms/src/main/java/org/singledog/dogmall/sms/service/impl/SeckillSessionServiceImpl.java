package org.singledog.dogmall.sms.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.sms.mapper.SeckillSessionMapper;
import org.singledog.dogmall.sms.entity.SeckillSessionEntity;
import org.singledog.dogmall.sms.service.SeckillSessionService;

import java.util.List;

@Service("seckillSessionService")
public class SeckillSessionServiceImpl extends ServiceImpl<SeckillSessionMapper, SeckillSessionEntity> implements SeckillSessionService {

    @Autowired
    private SeckillSessionMapper mapper;

    @Override
    public Response<List<SeckillSessionEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<SeckillSessionEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}