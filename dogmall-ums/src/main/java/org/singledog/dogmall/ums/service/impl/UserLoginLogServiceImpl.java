package org.singledog.dogmall.ums.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.ums.mapper.UserLoginLogMapper;
import org.singledog.dogmall.ums.entity.UserLoginLogEntity;
import org.singledog.dogmall.ums.service.UserLoginLogService;

import java.util.List;

@Service("userLoginLogService")
public class UserLoginLogServiceImpl extends ServiceImpl<UserLoginLogMapper, UserLoginLogEntity> implements UserLoginLogService {

    @Autowired
    private UserLoginLogMapper mapper;

    @Override
    public Response<List<UserLoginLogEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<UserLoginLogEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}