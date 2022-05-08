package org.singledog.dogmall.pms.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.pms.mapper.SpuDescMapper;
import org.singledog.dogmall.pms.entity.SpuDescEntity;
import org.singledog.dogmall.pms.service.SpuDescService;

import java.util.List;

@Service("spuDescService")
public class SpuDescServiceImpl extends ServiceImpl<SpuDescMapper, SpuDescEntity> implements SpuDescService {

    @Autowired
    private SpuDescMapper mapper;

    @Override
    public Response<List<SpuDescEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<SpuDescEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}