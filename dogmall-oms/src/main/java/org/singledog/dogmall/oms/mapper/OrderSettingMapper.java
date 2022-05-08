package org.singledog.dogmall.oms.mapper;

import org.singledog.dogmall.oms.entity.OrderSettingEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单配置信息
 * 
 * @author ZheMing Liu
 * @email dogmall@qq.com
 * @date 2022-05-03 23:46:31
 */
@Mapper
public interface OrderSettingMapper extends BaseMapper<OrderSettingEntity> {
	
}
