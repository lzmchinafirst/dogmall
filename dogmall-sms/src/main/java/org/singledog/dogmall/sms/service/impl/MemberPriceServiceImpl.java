package org.singledog.dogmall.sms.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.sms.mapper.MemberPriceMapper;
import org.singledog.dogmall.sms.entity.MemberPriceEntity;
import org.singledog.dogmall.sms.service.MemberPriceService;

import java.util.List;

@Service("memberPriceService")
public class MemberPriceServiceImpl extends ServiceImpl<MemberPriceMapper, MemberPriceEntity> implements MemberPriceService {

    @Autowired
    private MemberPriceMapper mapper;

    @Override
    public Response<List<MemberPriceEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<MemberPriceEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}