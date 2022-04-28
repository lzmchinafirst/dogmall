package org.singledog.dogmall.core.request;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * The base request for project.Don't use it in http sender,
 * just receive it on controller(This class can just use to
 * one table query).
 *
 * @author Zheming Liu
 * @see javax.management.Query
 * @since 1.0.0-RELEASE
 */
@Data
@ToString
public class BaseRequest {
    /**
     * Greater than
     */
    private List<String> gt;

    /**
     * Lower than
     */
    private List<String> lt;

    /**
     * Greater or equal
     */
    private List<String> ge;

    /**
     * Lower or equal
     */
    private List<String> le;

    /**
     * Equal
     */
    private List<String> eq;

    /**
     * The page size
     */
    private Integer pageSize;

    /**
     * The page number
     */
    private Integer pageNum;

    /**
     * Whether use page
     */
    private Boolean whetherPage;

    /**
     * Query the result
     *
     * @param baseMapper {@link BaseMapper}
     * @param <T>        result type
     * @return query result
     */
    public <T> List<T> query(BaseMapper<T> baseMapper) {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        if (gt != null && gt.size() > 0) {
            for (String gt : gt) {
                String[] split = gt.split("-");
                queryWrapper.gt(split[0], split[1]);
            }
        } else if (lt != null && lt.size() > 0) {
            for (String lt : lt) {
                String[] split = lt.split("-");
                queryWrapper.lt(split[0], split[1]);
            }
        } else if (ge != null && ge.size() > 0) {
            for (String ge : ge) {
                String[] split = ge.split("-");
                queryWrapper.ge(split[0], split[1]);
            }
        } else if (le != null && le.size() > 0) {
            for (String le : le) {
                String[] split = le.split("-");
                queryWrapper.le(split[0], split[1]);
            }
        } else if (eq != null && eq.size() > 0) {
            for (String eq : eq) {
                String[] split = eq.split("-");
                queryWrapper.eq(split[0], split[1]);
            }
        }
        if (whetherPage == null) {
            return baseMapper.selectList(queryWrapper);
        } else if (whetherPage) {
            Page<T> page = new Page<>(pageNum, pageSize);
            baseMapper.selectPage(page, queryWrapper);
            return page.getRecords();
        } else {
            return baseMapper.selectList(queryWrapper);
        }
    }

}
