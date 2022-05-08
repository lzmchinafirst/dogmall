package org.singledog.dogmall.core.request;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.singledog.dogmall.core.response.Response;

import java.util.List;

/**
 * The request for project
 *
 * @author ZheMing Liu
 * @since 1.0.0-RELEASE
 */
@FunctionalInterface
public interface Request {

    /**
     * Query method
     *
     * @param baseMapper {@link BaseMapper}
     * @return {@link Response}
     */
    <T> Response<List<T>> query(BaseMapper<T> baseMapper);
}
