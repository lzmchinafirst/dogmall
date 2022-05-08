package org.singledog.dogmall.sms.mapper;

import org.singledog.dogmall.sms.entity.SeckillSkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 秒杀活动商品关联
 * 
 * @author ZheMing Liu
 * @email dogmall@qq.com
 * @date 2022-05-03 23:49:55
 */
@Mapper
public interface SeckillSkuMapper extends BaseMapper<SeckillSkuEntity> {
	
}
