package org.singledog.dogmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.pms.entity.CommentReplayEntity;

import java.util.List;

/**
 * 商品评价回复关系
 *
 * @author Zheming Liu
 * @email dogmail@qq.com
 * @date 2022-04-23 19:43:11
 */
public interface CommentReplayService extends IService<CommentReplayEntity> {
    List<CommentReplayEntity> query(BaseRequest request);
}

