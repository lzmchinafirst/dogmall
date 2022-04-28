package org.singledog.dogmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.pms.entity.AttrGroupEntity;

import java.util.List;

/**
 * 属性分组
 *
 * @author Zheming Liu
 * @email dogmall@qq.com
 * @date 2022-04-23 19:43:11
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {
    List<AttrGroupEntity> query(BaseRequest request);
}

