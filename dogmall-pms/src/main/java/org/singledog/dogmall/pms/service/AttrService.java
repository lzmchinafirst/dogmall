package org.singledog.dogmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.pms.entity.AttrEntity;

import java.util.List;

/**
 * 商品属性
 *
 * @author Zheming Liu
 * @email dogmall@qq.com
 * @date 2022-04-23 19:43:11
 */
public interface AttrService extends IService<AttrEntity> {
    List<AttrEntity> query(BaseRequest request);
}

