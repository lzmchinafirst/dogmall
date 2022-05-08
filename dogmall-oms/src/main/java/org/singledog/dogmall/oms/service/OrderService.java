package org.singledog.dogmall.oms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.singledog.dogmall.oms.entity.OrderEntity;

import java.util.List;

/**
 * 订单
 *
 * @author ZheMing Liu
 * @email dogmall@qq.com
 * @date 2022-05-03 23:46:31
 */
public interface OrderService extends IService<OrderEntity> {

    /**
     * Base request
     *
     * @param request {@link BaseRequest}
     * @return query result without page
     */
    Response<List<OrderEntity>> queryBase(BaseRequest request);


    /**
     * Page request
     *
     * @param request {@link PageRequest}
     * @return query result with page
     */
    Response<List<OrderEntity>> queryPage(PageRequest request);
}

