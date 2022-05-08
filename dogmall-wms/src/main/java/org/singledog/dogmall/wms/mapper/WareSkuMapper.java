package org.singledog.dogmall.wms.mapper;

import org.singledog.dogmall.wms.entity.WareSkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品库存
 * 
 * @author ZheMing Liu
 * @email dogmall@qq.com
 * @date 2022-05-03 23:54:47
 */
@Mapper
public interface WareSkuMapper extends BaseMapper<WareSkuEntity> {
	
}
