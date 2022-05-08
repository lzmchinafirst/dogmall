package org.singledog.dogmall.ums.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.ums.mapper.UserStatisticsMapper;
import org.singledog.dogmall.ums.entity.UserStatisticsEntity;
import org.singledog.dogmall.ums.service.UserStatisticsService;

import java.util.List;

@Service("userStatisticsService")
public class UserStatisticsServiceImpl extends ServiceImpl<UserStatisticsMapper, UserStatisticsEntity> implements UserStatisticsService {

    @Autowired
    private UserStatisticsMapper mapper;

    @Override
    public Response<List<UserStatisticsEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<UserStatisticsEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}