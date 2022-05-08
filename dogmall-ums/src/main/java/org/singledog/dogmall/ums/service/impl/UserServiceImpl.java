package org.singledog.dogmall.ums.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.ums.mapper.UserMapper;
import org.singledog.dogmall.ums.entity.UserEntity;
import org.singledog.dogmall.ums.service.UserService;

import java.util.List;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public Response<List<UserEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<UserEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}