package org.singledog.dogmall.sms.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.sms.mapper.HomeSubjectMapper;
import org.singledog.dogmall.sms.entity.HomeSubjectEntity;
import org.singledog.dogmall.sms.service.HomeSubjectService;

import java.util.List;

@Service("homeSubjectService")
public class HomeSubjectServiceImpl extends ServiceImpl<HomeSubjectMapper, HomeSubjectEntity> implements HomeSubjectService {

    @Autowired
    private HomeSubjectMapper mapper;

    @Override
    public Response<List<HomeSubjectEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<HomeSubjectEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}