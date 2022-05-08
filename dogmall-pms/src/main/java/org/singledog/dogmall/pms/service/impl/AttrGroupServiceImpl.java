package org.singledog.dogmall.pms.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.pms.mapper.AttrGroupMapper;
import org.singledog.dogmall.pms.entity.AttrGroupEntity;
import org.singledog.dogmall.pms.service.AttrGroupService;

import java.util.List;

@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupMapper, AttrGroupEntity> implements AttrGroupService {

    @Autowired
    private AttrGroupMapper mapper;

    @Override
    public Response<List<AttrGroupEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<AttrGroupEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}