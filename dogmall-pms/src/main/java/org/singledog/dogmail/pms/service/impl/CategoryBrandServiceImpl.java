package org.singledog.dogmail.pms.service.impl;

import org.singledog.dogmail.core.request.BaseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmail.pms.mapper.CategoryBrandMapper;
import org.singledog.dogmail.pms.entity.CategoryBrandEntity;
import org.singledog.dogmail.pms.service.CategoryBrandService;

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