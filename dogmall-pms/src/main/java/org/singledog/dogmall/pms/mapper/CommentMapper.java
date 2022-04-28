package org.singledog.dogmall.pms.mapper;

import org.singledog.dogmall.pms.entity.CommentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评价
 * 
 * @author Zheming Liu
 * @email dogmall@qq.com
 * @date 2022-04-23 19:43:11
 */
@Mapper
public interface CommentMapper extends BaseMapper<CommentEntity> {
	
}
