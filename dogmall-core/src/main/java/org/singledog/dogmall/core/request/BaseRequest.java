package org.singledog.dogmall.core.request;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.singledog.dogmall.core.response.ResponseEntity;
import org.singledog.dogmall.core.response.ResponseFactory;

import java.util.List;

/**
 * The base request for project.Don't use it in http sender,
 * just receive it on controller(This class can just use to
 * one table query).
 *
 * @author ZheMing Liu
 * @since 1.0.0-RELEASE
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BaseRequest extends RequestElement implements Request, PluginHandler<QueryWrapper> {

    /**
     * If you don't want to use {@link RequestElement} to handle your wrapper,
     * you can custom handle rule.
     */
    private PluginHandler<QueryWrapper> handler;

    /**
     * Query the result
     *
     * @param baseMapper {@link BaseMapper}
     * @param <T>        result type
     * @return query result
     */
    @Override
    public <T> ResponseEntity<List<T>> query(BaseMapper<T> baseMapper) {
        QueryWrapper<T> queryWrapper = getQueryWrapper(baseMapper);
        handlePlugin(queryWrapper);
        return ResponseFactory.getSuccessResponse(baseMapper.selectList(queryWrapper));
    }

    @Override
    public void handlePlugin(QueryWrapper plugin) {
        if (handler != null) {
            handler.handlePlugin(plugin);
        }
    }
}
