package org.singledog.dogmall.pms.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.pms.mapper.AttrMapper;
import org.singledog.dogmall.pms.entity.AttrEntity;
import org.singledog.dogmall.pms.service.AttrService;

import java.util.List;

@Service("attrService")
public class AttrServiceImpl extends ServiceImpl<AttrMapper, AttrEntity> implements AttrService {

    @Autowired
    private AttrMapper mapper;

    @Override
    public Response<List<AttrEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<AttrEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}