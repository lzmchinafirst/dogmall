package org.singledog.dogmall.ums.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.ums.mapper.UserCollectSkuMapper;
import org.singledog.dogmall.ums.entity.UserCollectSkuEntity;
import org.singledog.dogmall.ums.service.UserCollectSkuService;

import java.util.List;

@Service("userCollectSkuService")
public class UserCollectSkuServiceImpl extends ServiceImpl<UserCollectSkuMapper, UserCollectSkuEntity> implements UserCollectSkuService {

    @Autowired
    private UserCollectSkuMapper mapper;

    @Override
    public Response<List<UserCollectSkuEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<UserCollectSkuEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}