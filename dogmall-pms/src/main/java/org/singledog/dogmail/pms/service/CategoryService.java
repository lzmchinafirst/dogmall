package org.singledog.dogmail.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.singledog.dogmail.core.request.BaseRequest;
import org.singledog.dogmail.pms.entity.CategoryEntity;

import java.util.List;

/**
 * 商品三级分类
 *
 * @author Zheming Liu
 * @email dogmail@qq.com
 * @date 2022-04-23 19:43:11
 */
public interface CategoryService extends IService<CategoryEntity> {
    List<CategoryEntity> query(BaseRequest request);
}

