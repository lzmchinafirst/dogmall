package org.singledog.dogmall.sms.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.singledog.dogmall.core.response.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.singledog.dogmall.sms.entity.CouponSpuCategoryEntity;
import org.singledog.dogmall.sms.service.CouponSpuCategoryService;

/**
 * 优惠券分类关联
 *
 * @author ZheMing Liu
 * @email dogmall@qq.com
 * @date 2022-05-03 23:49:55
 */
@Api(tags = "优惠券分类关联 管理")
@RestController
@RequestMapping("sms/couponspucategory")
public class CouponSpuCategoryController {

    @Autowired
    private CouponSpuCategoryService couponSpuCategoryService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("分页查询")
    public Response<List<CouponSpuCategoryEntity>> queryCouponSpuCategoryByPage(PageRequest request) {
        return couponSpuCategoryService.queryPage(request);
    }


    /**
     * 信息
     */
    @GetMapping("{id}")
    @ApiOperation("详情查询")
    public Response<CouponSpuCategoryEntity> queryCouponSpuCategoryById(@PathVariable("id") Long id) {
        CouponSpuCategoryEntity entity = couponSpuCategoryService.getById(id);
        return ResponseFactory.getSuccessResponse(entity);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public Response save(@RequestBody CouponSpuCategoryEntity couponSpuCategory) {
        couponSpuCategoryService.save(couponSpuCategory);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改")
    public Response update(@RequestBody CouponSpuCategoryEntity couponSpuCategory) {
        couponSpuCategoryService.updateById(couponSpuCategory);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除")
    public Response delete(@RequestBody List<Long> ids) {
        couponSpuCategoryService.removeByIds(ids);
        return ResponseFactory.getSuccessResponse();
    }

}
