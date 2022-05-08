package org.singledog.dogmall.core.request;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * The request element
 *
 * @author ZheMing Liu
 * @since 1.0.0-RELEASE
 */
@Data
@ToString
@Slf4j
public class RequestElement {

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
     * The in condition
     */
    private List<String> in;

    /**
     * Like search
     */
    private List<String> like;

    /**
     * Positive sequence
     */
    private List<String> asc;

    /**
     * Flashback
     */
    private List<String> desc;

    /**
     * Whether use empty {@link QueryWrapper}
     */
    private Boolean useEmptyWrapper = Boolean.FALSE;

    /**
     * Get the {@link QueryWrapper}
     *
     * @param baseMapper {@link BaseMapper}
     * @param <T>        the request type
     * @return {@link QueryWrapper}
     */
    protected <T> QueryWrapper<T> getQueryWrapper(BaseMapper<T> baseMapper) {
        log.info("The method getQueryWrapper param is {}", baseMapper);
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        if (useEmptyWrapper) {
            return queryWrapper;
        }
        if (gt != null && gt.size() > 0) {
            for (String gt : gt) {
                String[] split = gt.split("-");
                queryWrapper.gt(split[0], Long.valueOf(split[1]));
            }
        }
        if (lt != null && lt.size() > 0) {
            for (String lt : lt) {
                String[] split = lt.split("-");
                queryWrapper.lt(split[0], Long.valueOf(split[1]));
            }
        }
        if (ge != null && ge.size() > 0) {
            for (String ge : ge) {
                String[] split = ge.split("-");
                queryWrapper.ge(split[0], Long.valueOf(split[1]));
            }
        }
        if (le != null && le.size() > 0) {
            for (String le : le) {
                String[] split = le.split("-");
                queryWrapper.le(split[0], Long.valueOf(split[1]));
            }
        }
        if (eq != null && eq.size() > 0) {
            for (String eq : eq) {
                String[] split = eq.split("-");
                queryWrapper.eq(split[0], split[1]);
            }
        }
        if (in != null && in.size() > 0) {
            Map<String, List<String>> inMap = new HashMap<>(2);
            for (String in : in) {
                String[] split = in.split("-");
                if (!inMap.containsKey(split[0])) {
                    ArrayList<String> valueList = new ArrayList(4);
                    valueList.add(split[1]);
                    inMap.put(split[0], valueList);
                } else {
                    List<String> valueList = inMap.get(split[0]);
                    valueList.add(split[1]);
                }
            }
            for (String key : inMap.keySet()) {
                queryWrapper.in(key, inMap.get(key));
            }
        }
        if (like != null && like.size() > 0) {
            for (String like : like) {
                String[] split = like.split("-");
                queryWrapper.like(split[0], split[1]);
            }
        }
        if (asc != null && asc.size() > 0) {
            queryWrapper.orderByAsc(asc);
        }
        if (desc != null && desc.size() > 0) {
            queryWrapper.orderByDesc(desc);
        }
        return queryWrapper;
    }
}
