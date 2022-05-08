package org.singledog.dogmall.ums.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.ums.mapper.GrowthHistoryMapper;
import org.singledog.dogmall.ums.entity.GrowthHistoryEntity;
import org.singledog.dogmall.ums.service.GrowthHistoryService;

import java.util.List;

@Service("growthHistoryService")
public class GrowthHistoryServiceImpl extends ServiceImpl<GrowthHistoryMapper, GrowthHistoryEntity> implements GrowthHistoryService {

    @Autowired
    private GrowthHistoryMapper mapper;

    @Override
    public Response<List<GrowthHistoryEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<GrowthHistoryEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}