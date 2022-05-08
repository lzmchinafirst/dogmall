package org.singledog.dogmall.pms.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.pms.mapper.CategoryBrandMapper;
import org.singledog.dogmall.pms.entity.CategoryBrandEntity;
import org.singledog.dogmall.pms.service.CategoryBrandService;

import java.util.List;

@Service("categoryBrandService")
public class CategoryBrandServiceImpl extends ServiceImpl<CategoryBrandMapper, CategoryBrandEntity> implements CategoryBrandService {

    @Autowired
    private CategoryBrandMapper mapper;

    @Override
    public Response<List<CategoryBrandEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<CategoryBrandEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}