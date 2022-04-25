package org.singledog.dogmail.pms.service.impl;

import org.singledog.dogmail.core.request.BaseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmail.pms.mapper.AttrMapper;
import org.singledog.dogmail.pms.entity.AttrEntity;
import org.singledog.dogmail.pms.service.AttrService;

import java.util.List;


@Service("attrService")
public class AttrServiceImpl extends ServiceImpl<AttrMapper, AttrEntity> implements AttrService {

    private AttrMapper attrMapper;

    @Autowired
    public AttrServiceImpl(AttrMapper attrMapper) {
        this.attrMapper = attrMapper;
    }

    @Override
    public List<AttrEntity> query(BaseRequest request) {
        return request.query(attrMapper);
    }
}