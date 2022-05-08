package org.singledog.dogmall.ums.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.ums.mapper.UserLevelMapper;
import org.singledog.dogmall.ums.entity.UserLevelEntity;
import org.singledog.dogmall.ums.service.UserLevelService;

import java.util.List;

@Service("userLevelService")
public class UserLevelServiceImpl extends ServiceImpl<UserLevelMapper, UserLevelEntity> implements UserLevelService {

    @Autowired
    private UserLevelMapper mapper;

    @Override
    public Response<List<UserLevelEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<UserLevelEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}