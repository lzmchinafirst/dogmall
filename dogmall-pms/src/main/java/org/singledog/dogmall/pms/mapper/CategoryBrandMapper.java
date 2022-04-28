package org.singledog.dogmall.pms.mapper;

import org.singledog.dogmall.pms.entity.CategoryBrandEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 品牌分类关联
 * 
 * @author Zheming Liu
 * @email dogmail@qq.com
 * @date 2022-04-23 19:43:11
 */
@Mapper
public interface CategoryBrandMapper extends BaseMapper<CategoryBrandEntity> {
	
}
