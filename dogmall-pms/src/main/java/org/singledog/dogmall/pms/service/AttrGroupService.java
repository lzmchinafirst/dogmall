package org.singledog.dogmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.singledog.dogmall.pms.entity.AttrGroupEntity;

import java.util.List;

/**
 * 属性分组
 *
 * @author ZheMing Liu
 * @email dogmall@qq.com
 * @date 2022-05-03 20:38:58
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    /**
     * Base request
     *
     * @param request {@link BaseRequest}
     * @return query result without page
     */
    Response<List<AttrGroupEntity>> queryBase(BaseRequest request);


    /**
     * Page request
     *
     * @param request {@link PageRequest}
     * @return query result with page
     */
    Response<List<AttrGroupEntity>> queryPage(PageRequest request);
}

