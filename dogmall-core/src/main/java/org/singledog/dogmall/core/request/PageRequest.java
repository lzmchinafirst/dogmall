package org.singledog.dogmall.core.request;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.singledog.dogmall.core.response.ResponseFactory;
import org.singledog.dogmall.core.response.ResponsePageEntity;

import java.util.List;

/**
 * The page request for project.Don't use it in http sender,
 * just receive it on controller(This class can just use to
 * one table query).The default page size and page number are 10 and 1.
 *
 * @author ZheMing Liu
 * @since 1.0.0-RELEASE
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PageRequest extends RequestElement implements Request, PluginHandler<QueryWrapper> {

    /**
     * If you don't want to use {@link RequestElement} to handle your wrapper,
     * you can custom handle rules.
     */
    private PluginHandler<QueryWrapper> handler;

    /**
     * The page size
     */
    private Long pageSize = 10L;

    /**
     * The pageNum
     */
    private Long pageNum = 1L;

    @Override
    public <T> ResponsePageEntity<List<T>> query(BaseMapper<T> baseMapper) {
        QueryWrapper<T> queryWrapper = getQueryWrapper(baseMapper);
        handlePlugin(queryWrapper);
        Page<T> page = new Page<>(pageNum, pageSize);
        baseMapper.selectPage(page, queryWrapper);
        return ResponseFactory.getSuccessPageResponse(page.getRecords(), page.getPages(), page.getCurrent(), page.getSize(), page.getTotal());
    }

    @Override
    public void handlePlugin(QueryWrapper plugin) {
        if (handler != null) {
            handler.handlePlugin(plugin);
        }
    }
}
