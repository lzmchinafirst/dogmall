package org.singledog.dogmall.pms.service.impl;

import org.singledog.dogmall.core.request.BaseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.pms.mapper.CategoryBrandMapper;
import org.singledog.dogmall.pms.entity.CategoryBrandEntity;
import org.singledog.dogmall.pms.service.CategoryBrandService;

import java.util.List;


@Service("categoryBrandService")
public class CategoryBrandServiceImpl extends ServiceImpl<CategoryBrandMapper, CategoryBrandEntity> implements CategoryBrandService {

    private CategoryBrandMapper categoryBrandMapper;

    @Autowired
    public CategoryBrandServiceImpl(CategoryBrandMapper categoryBrandMapper) {
        this.categoryBrandMapper = categoryBrandMapper;
    }

    @Override
    public List<CategoryBrandEntity> query(BaseRequest request) {
        return request.query(categoryBrandMapper);
    }
}