package org.singledog.dogmall.pms.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.pms.mapper.SpuAttrValueMapper;
import org.singledog.dogmall.pms.entity.SpuAttrValueEntity;
import org.singledog.dogmall.pms.service.SpuAttrValueService;

import java.util.List;

@Service("spuAttrValueService")
public class SpuAttrValueServiceImpl extends ServiceImpl<SpuAttrValueMapper, SpuAttrValueEntity> implements SpuAttrValueService {

    @Autowired
    private SpuAttrValueMapper mapper;

    @Override
    public Response<List<SpuAttrValueEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<SpuAttrValueEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}