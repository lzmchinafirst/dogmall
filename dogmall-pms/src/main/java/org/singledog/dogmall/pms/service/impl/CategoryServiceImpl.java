package org.singledog.dogmall.pms.service.impl;

import org.singledog.dogmall.core.request.BaseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.pms.mapper.CategoryMapper;
import org.singledog.dogmall.pms.entity.CategoryEntity;
import org.singledog.dogmall.pms.service.CategoryService;

import java.util.List;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, CategoryEntity> implements CategoryService {

    private CategoryMapper categoryMapper;

    @Autowired
    public CategoryServiceImpl(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<CategoryEntity> query(BaseRequest request) {
        return request.query(categoryMapper);
    }
}