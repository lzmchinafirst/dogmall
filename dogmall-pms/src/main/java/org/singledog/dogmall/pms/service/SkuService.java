package org.singledog.dogmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.pms.entity.SkuEntity;

import java.util.List;

/**
 * sku信息
 *
 * @author Zheming Liu
 * @email dogmail@qq.com
 * @date 2022-04-23 19:43:11
 */
public interface SkuService extends IService<SkuEntity> {
    List<SkuEntity> query(BaseRequest request);
}

