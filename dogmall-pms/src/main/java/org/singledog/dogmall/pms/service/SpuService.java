package org.singledog.dogmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.pms.entity.SpuEntity;

import java.util.List;

/**
 * spu信息
 *
 * @author Zheming Liu
 * @email dogmail@qq.com
 * @date 2022-04-23 19:43:11
 */
public interface SpuService extends IService<SpuEntity> {
    List<SpuEntity> queryPage(BaseRequest request);
}

