package org.singledog.dogmall.ums.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.ums.mapper.UserCollectShopMapper;
import org.singledog.dogmall.ums.entity.UserCollectShopEntity;
import org.singledog.dogmall.ums.service.UserCollectShopService;

import java.util.List;

@Service("userCollectShopService")
public class UserCollectShopServiceImpl extends ServiceImpl<UserCollectShopMapper, UserCollectShopEntity> implements UserCollectShopService {

    @Autowired
    private UserCollectShopMapper mapper;

    @Override
    public Response<List<UserCollectShopEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<UserCollectShopEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}