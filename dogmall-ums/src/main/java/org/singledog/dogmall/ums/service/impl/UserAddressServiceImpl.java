package org.singledog.dogmall.ums.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.ums.mapper.UserAddressMapper;
import org.singledog.dogmall.ums.entity.UserAddressEntity;
import org.singledog.dogmall.ums.service.UserAddressService;

import java.util.List;

@Service("userAddressService")
public class UserAddressServiceImpl extends ServiceImpl<UserAddressMapper, UserAddressEntity> implements UserAddressService {

    @Autowired
    private UserAddressMapper mapper;

    @Override
    public Response<List<UserAddressEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<UserAddressEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}