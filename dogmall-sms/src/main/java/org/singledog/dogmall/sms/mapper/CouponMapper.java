package org.singledog.dogmall.sms.mapper;

import org.singledog.dogmall.sms.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author ZheMing Liu
 * @email dogmall@qq.com
 * @date 2022-05-03 23:49:56
 */
@Mapper
public interface CouponMapper extends BaseMapper<CouponEntity> {
	
}
