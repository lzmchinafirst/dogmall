package org.singledog.dogmall.sms.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.sms.mapper.HomeSubjectSpuMapper;
import org.singledog.dogmall.sms.entity.HomeSubjectSpuEntity;
import org.singledog.dogmall.sms.service.HomeSubjectSpuService;

import java.util.List;

@Service("homeSubjectSpuService")
public class HomeSubjectSpuServiceImpl extends ServiceImpl<HomeSubjectSpuMapper, HomeSubjectSpuEntity> implements HomeSubjectSpuService {

    @Autowired
    private HomeSubjectSpuMapper mapper;

    @Override
    public Response<List<HomeSubjectSpuEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<HomeSubjectSpuEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}