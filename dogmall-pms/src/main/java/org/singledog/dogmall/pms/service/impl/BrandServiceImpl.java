package org.singledog.dogmall.pms.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.pms.mapper.BrandMapper;
import org.singledog.dogmall.pms.entity.BrandEntity;
import org.singledog.dogmall.pms.service.BrandService;

import java.util.List;

@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandMapper, BrandEntity> implements BrandService {

    @Autowired
    private BrandMapper mapper;

    @Override
    public Response<List<BrandEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<BrandEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}