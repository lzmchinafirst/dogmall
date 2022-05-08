package org.singledog.dogmall.ums.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.ums.mapper.UserCollectSubjectMapper;
import org.singledog.dogmall.ums.entity.UserCollectSubjectEntity;
import org.singledog.dogmall.ums.service.UserCollectSubjectService;

import java.util.List;

@Service("userCollectSubjectService")
public class UserCollectSubjectServiceImpl extends ServiceImpl<UserCollectSubjectMapper, UserCollectSubjectEntity> implements UserCollectSubjectService {

    @Autowired
    private UserCollectSubjectMapper mapper;

    @Override
    public Response<List<UserCollectSubjectEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<UserCollectSubjectEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}