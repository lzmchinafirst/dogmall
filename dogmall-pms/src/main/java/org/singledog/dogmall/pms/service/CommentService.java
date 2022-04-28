package org.singledog.dogmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.pms.entity.CommentEntity;

import java.util.List;

/**
 * 商品评价
 *
 * @author Zheming Liu
 * @email dogmail@qq.com
 * @date 2022-04-23 19:43:11
 */
public interface CommentService extends IService<CommentEntity> {
    List<CommentEntity> query(BaseRequest request);
}

