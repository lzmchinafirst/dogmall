package org.singledog.dogmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.pms.entity.SpuDescEntity;

import java.util.List;


/**
 * spu信息介绍
 *
 * @author Zheming Liu
 * @email dogmall@qq.com
 * @date 2022-04-23 19:43:11
 */
public interface SpuDescService extends IService<SpuDescEntity> {
    List<SpuDescEntity> queryPage(BaseRequest request);
}

