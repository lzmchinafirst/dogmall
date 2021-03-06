package org.singledog.dogmall.sms.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.singledog.dogmall.core.response.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.singledog.dogmall.sms.entity.CouponSpuEntity;
import org.singledog.dogmall.sms.service.CouponSpuService;

/**
 * 优惠券与产品关联
 *
 * @author ZheMing Liu
 * @email dogmall@qq.com
 * @date 2022-05-03 23:49:55
 */
@Api(tags = "优惠券与产品关联 管理")
@RestController
@RequestMapping("sms/couponspu")
public class CouponSpuController {

    @Autowired
    private CouponSpuService couponSpuService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("分页查询")
    public Response<List<CouponSpuEntity>> queryCouponSpuByPage(PageRequest request) {
        return couponSpuService.queryPage(request);
    }


    /**
     * 信息
     */
    @GetMapping("{id}")
    @ApiOperation("详情查询")
    public Response<CouponSpuEntity> queryCouponSpuById(@PathVariable("id") Long id) {
        CouponSpuEntity entity = couponSpuService.getById(id);
        return ResponseFactory.getSuccessResponse(entity);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    @Transactional(rollbackFor = Exception.class)
    public Response save(@RequestBody CouponSpuEntity couponSpu) {
        couponSpuService.save(couponSpu);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改")
    public Response update(@RequestBody CouponSpuEntity couponSpu) {
        couponSpuService.updateById(couponSpu);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除")
    public Response delete(@RequestBody List<Long> ids) {
        couponSpuService.removeByIds(ids);
        return ResponseFactory.getSuccessResponse();
    }

}
