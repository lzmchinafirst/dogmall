package org.singledog.dogmall.ums.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.singledog.dogmall.ums.entity.UserLoginLogEntity;

import java.util.List;

/**
 * 用户登陆记录表
 *
 * @author ZheMing Liu
 * @email dogmall@qq.com
 * @date 2022-05-03 23:52:33
 */
public interface UserLoginLogService extends IService<UserLoginLogEntity> {

    /**
     * Base request
     *
     * @param request {@link BaseRequest}
     * @return query result without page
     */
    Response<List<UserLoginLogEntity>> queryBase(BaseRequest request);


    /**
     * Page request
     *
     * @param request {@link PageRequest}
     * @return query result with page
     */
    Response<List<UserLoginLogEntity>> queryPage(PageRequest request);
}

