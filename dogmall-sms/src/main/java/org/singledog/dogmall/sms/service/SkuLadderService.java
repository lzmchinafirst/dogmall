package org.singledog.dogmall.sms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.singledog.dogmall.sms.entity.SkuLadderEntity;

import java.util.List;

/**
 * 商品阶梯价格
 *
 * @author ZheMing Liu
 * @email dogmall@qq.com
 * @date 2022-05-03 23:49:55
 */
public interface SkuLadderService extends IService<SkuLadderEntity> {

    /**
     * Base request
     *
     * @param request {@link BaseRequest}
     * @return query result without page
     */
    Response<List<SkuLadderEntity>> queryBase(BaseRequest request);


    /**
     * Page request
     *
     * @param request {@link PageRequest}
     * @return query result with page
     */
    Response<List<SkuLadderEntity>> queryPage(PageRequest request);
}

