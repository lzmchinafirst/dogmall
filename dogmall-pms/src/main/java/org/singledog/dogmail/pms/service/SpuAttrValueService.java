package org.singledog.dogmail.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.singledog.dogmail.core.request.BaseRequest;
import org.singledog.dogmail.pms.entity.SpuAttrValueEntity;

import java.util.List;

/**
 * spu属性值
 *
 * @author Zheming Liu
 * @email dogmail@qq.com
 * @date 2022-04-23 19:43:11
 */
public interface SpuAttrValueService extends IService<SpuAttrValueEntity> {
    List<SpuAttrValueEntity> queryPage(BaseRequest request);
}

