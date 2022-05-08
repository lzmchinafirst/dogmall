package org.singledog.dogmall.sms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.singledog.dogmall.sms.entity.SeckillPromotionEntity;

import java.util.List;

/**
 * 秒杀活动
 *
 * @author ZheMing Liu
 * @email dogmall@qq.com
 * @date 2022-05-03 23:49:55
 */
public interface SeckillPromotionService extends IService<SeckillPromotionEntity> {

    /**
     * Base request
     *
     * @param request {@link BaseRequest}
     * @return query result without page
     */
    Response<List<SeckillPromotionEntity>> queryBase(BaseRequest request);


    /**
     * Page request
     *
     * @param request {@link PageRequest}
     * @return query result with page
     */
    Response<List<SeckillPromotionEntity>> queryPage(PageRequest request);
}

