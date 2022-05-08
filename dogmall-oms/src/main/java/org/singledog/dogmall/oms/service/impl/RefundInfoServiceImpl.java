package org.singledog.dogmall.oms.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.oms.mapper.RefundInfoMapper;
import org.singledog.dogmall.oms.entity.RefundInfoEntity;
import org.singledog.dogmall.oms.service.RefundInfoService;

import java.util.List;

@Service("refundInfoService")
public class RefundInfoServiceImpl extends ServiceImpl<RefundInfoMapper, RefundInfoEntity> implements RefundInfoService {

    @Autowired
    private RefundInfoMapper mapper;

    @Override
    public Response<List<RefundInfoEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<RefundInfoEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}