package org.singledog.dogmail.pms.mapper;

import org.singledog.dogmail.pms.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author Zheming Liu
 * @email dogmail@qq.com
 * @date 2022-04-23 19:43:11
 */
@Mapper
public interface CategoryMapper extends BaseMapper<CategoryEntity> {
	
}
