package org.singledog.dogmall.sms.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.sms.mapper.SeckillSkuNoticeMapper;
import org.singledog.dogmall.sms.entity.SeckillSkuNoticeEntity;
import org.singledog.dogmall.sms.service.SeckillSkuNoticeService;

import java.util.List;

@Service("seckillSkuNoticeService")
public class SeckillSkuNoticeServiceImpl extends ServiceImpl<SeckillSkuNoticeMapper, SeckillSkuNoticeEntity> implements SeckillSkuNoticeService {

    @Autowired
    private SeckillSkuNoticeMapper mapper;

    @Override
    public Response<List<SeckillSkuNoticeEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<SeckillSkuNoticeEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}