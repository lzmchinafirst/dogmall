package org.singledog.dogmall.sms.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.sms.mapper.SkuLadderMapper;
import org.singledog.dogmall.sms.entity.SkuLadderEntity;
import org.singledog.dogmall.sms.service.SkuLadderService;

import java.util.List;

@Service("skuLadderService")
public class SkuLadderServiceImpl extends ServiceImpl<SkuLadderMapper, SkuLadderEntity> implements SkuLadderService {

    @Autowired
    private SkuLadderMapper mapper;

    @Override
    public Response<List<SkuLadderEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<SkuLadderEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}