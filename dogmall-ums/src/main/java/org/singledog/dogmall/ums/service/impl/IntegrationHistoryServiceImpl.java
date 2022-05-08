package org.singledog.dogmall.ums.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.ums.mapper.IntegrationHistoryMapper;
import org.singledog.dogmall.ums.entity.IntegrationHistoryEntity;
import org.singledog.dogmall.ums.service.IntegrationHistoryService;

import java.util.List;

@Service("integrationHistoryService")
public class IntegrationHistoryServiceImpl extends ServiceImpl<IntegrationHistoryMapper, IntegrationHistoryEntity> implements IntegrationHistoryService {

    @Autowired
    private IntegrationHistoryMapper mapper;

    @Override
    public Response<List<IntegrationHistoryEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<IntegrationHistoryEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}