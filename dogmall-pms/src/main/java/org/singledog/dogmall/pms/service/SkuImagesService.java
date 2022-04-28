package org.singledog.dogmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.pms.entity.SkuImagesEntity;

import java.util.List;

/**
 * sku图片
 *
 * @author Zheming Liu
 * @email dogmall@qq.com
 * @date 2022-04-23 19:43:11
 */
public interface SkuImagesService extends IService<SkuImagesEntity> {
    List<SkuImagesEntity> query(BaseRequest request);
}

