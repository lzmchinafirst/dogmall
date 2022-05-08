package org.singledog.dogmall.ums.mapper;

import org.singledog.dogmall.ums.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表
 * 
 * @author ZheMing Liu
 * @email dogmall@qq.com
 * @date 2022-05-03 23:52:33
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
	
}
