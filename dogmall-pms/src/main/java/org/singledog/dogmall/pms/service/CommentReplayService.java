package org.singledog.dogmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.singledog.dogmall.pms.entity.CommentReplayEntity;

import java.util.List;

/**
 * 商品评价回复关系
 *
 * @author ZheMing Liu
 * @email dogmall@qq.com
 * @date 2022-05-03 20:38:58
 */
public interface CommentReplayService extends IService<CommentReplayEntity> {

    /**
     * Base request
     *
     * @param request {@link BaseRequest}
     * @return query result without page
     */
    Response<List<CommentReplayEntity>> queryBase(BaseRequest request);


    /**
     * Page request
     *
     * @param request {@link PageRequest}
     * @return query result with page
     */
    Response<List<CommentReplayEntity>> queryPage(PageRequest request);
}

